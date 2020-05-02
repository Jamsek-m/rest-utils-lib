package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.exceptions.ValidationException;
import com.mjamsek.rest.services.Validator;
import com.mjamsek.rest.test.common.ValidationExecutor;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Arquillian.class)
public class ValidatorTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(Validator.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    private Validator validator;
    
    @Test
    public void testValidatorMethods() {
        ValidationException thrownExc;
        
        // Test when it should throw
        thrownExc = testThrown(() -> validator.assertNotNull(null));
        assertEquals((Object) Response.Status.BAD_REQUEST.getStatusCode(), thrownExc.getResponse().getStatus());
        
        thrownExc = testThrown(() -> validator.assertNotNull(null, "lastName"));
        assertEquals("lastName", thrownExc.getResponse().getField());
        
        thrownExc = testThrown(() -> validator.assertNotNull(null, "lastName", "Person"));
        assertEquals("lastName", thrownExc.getResponse().getField());
        assertEquals("Person", thrownExc.getResponse().getEntity());
        
        // Test when it should not throw
        testNotThrown(() -> validator.assertNotNull("null"));
        testNotThrown(() -> validator.assertNotNull(123));
        testNotThrown(() -> validator.assertNotNull(456.789));
        testNotThrown(() -> validator.assertNotNull(true));
        
    }
    
    private ValidationException testThrown(ValidationExecutor func) {
        try {
            func.execute();
            fail("Validation exception was not thrown!");
            return null;
        } catch (ValidationException e) {
            return e;
        }
    }
    
    private void testNotThrown(ValidationExecutor func) {
        try {
            func.execute();
        } catch (ValidationException e) {
            fail("Validation exception was thrown!");
        }
    }
    
}
