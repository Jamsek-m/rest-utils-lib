package com.mjamsek.rest.test.tests.cdi;

import com.mjamsek.rest.exceptions.ValidationException;
import com.mjamsek.rest.services.Localizator;
import com.mjamsek.rest.services.Validator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertThrows;

/**
 * Verifies CDI creating valid {@link Validator} instance
 * @author Miha Jamsek
 * @since 2.0.0
 */
@RunWith(Arquillian.class)
public class ValidatorCDITest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(Validator.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    private Validator validator;
    
    @Test
    public void createdBean() {
        validator.assertNotNull("");
        assertThrows(ValidationException.class, () -> validator.assertNotNull(null));
    }
    
}
