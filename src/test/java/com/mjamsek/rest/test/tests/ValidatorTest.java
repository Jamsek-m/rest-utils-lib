package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.Rest;
import com.mjamsek.rest.exceptions.ValidationException;
import com.mjamsek.rest.factories.ValidatorFactory;
import com.mjamsek.rest.services.Validator;
import com.mjamsek.rest.test.types.ValidationExecutor;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ValidatorTest {
    
    private static final String FIELD_NAME = "lastName";
    private static final String ENTITY_NAME = "Person";
    
    private static final String SIMPLE_REGEX = "[a-zA-Z-_]+";
    
    private Validator validator;
    
    @Before
    public void init() {
        this.validator = ValidatorFactory.getNewInstance();
    }
    
    @Test
    public void notNull() {
        // Assert invalid values are rejected
        assertThrows(ValidationException.class, () -> validator.assertNotNull(null));
        
        // Assert valid values are not rejected
        assertNotThrown(() -> validator.assertNotNull("test"));
        assertNotThrown(() -> validator.assertNotNull(""));
        assertNotThrown(() -> validator.assertNotNull("  "));
        assertNotThrown(() -> validator.assertNotNull(' '));
        assertNotThrown(() -> validator.assertNotNull('a'));
        assertNotThrown(() -> validator.assertNotNull(123));
        assertNotThrown(() -> validator.assertNotNull(0));
        assertNotThrown(() -> validator.assertNotNull(0.0));
        assertNotThrown(() -> validator.assertNotNull(2.5));
        assertNotThrown(() -> validator.assertNotNull(false));
        assertNotThrown(() -> validator.assertNotNull(true));
        
        // Assert thrown exception contains proper fields
        assertExceptionFields(
            () -> validator.assertNotNull(null),
            () -> validator.assertNotNull(null, FIELD_NAME),
            () -> validator.assertNotNull(null, FIELD_NAME, ENTITY_NAME),
            Response.Status.BAD_REQUEST.getStatusCode()
        );
    }
    
    @Test
    public void notBlank() {
        // Assert invalid values are rejected
        assertThrows(ValidationException.class, () -> validator.assertNotBlank(""));
        assertThrows(ValidationException.class, () -> validator.assertNotBlank("   "));
        assertThrows(ValidationException.class, () -> validator.assertNotBlank(null));
        
        // Assert valid values are not rejected
        assertNotThrown(() -> validator.assertNotBlank("test"));
        assertNotThrown(() -> validator.assertNotBlank("  test  "));
        assertNotThrown(() -> validator.assertNotBlank("  test \n test"));
        assertNotThrown(() -> validator.assertNotBlank("test  "));
        assertNotThrown(() -> validator.assertNotBlank("   test"));
        
        // Assert thrown exception contains proper fields
        assertExceptionFields(
            () -> validator.assertNotBlank(""),
            () -> validator.assertNotBlank("", FIELD_NAME),
            () -> validator.assertNotBlank("", FIELD_NAME, ENTITY_NAME),
            Response.Status.BAD_REQUEST.getStatusCode()
        );
    }
    
    @Test
    public void regex() {
        // Assert invalid values are rejected
        assertThrows(ValidationException.class, () -> validator.assertRegex(null, SIMPLE_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("", SIMPLE_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("test@test", SIMPLE_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("123", SIMPLE_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("te st@test.com", Validator.EMAIL_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("test@te st.com", Validator.EMAIL_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("test@test.c om", Validator.EMAIL_REGEX));
        assertThrows(ValidationException.class, () -> validator.assertRegex("test", Validator.EMAIL_REGEX));
        
        // Assert valid values are not rejected
        assertNotThrown(() -> validator.assertRegex("", ".*"));
        assertNotThrown(() -> validator.assertRegex("simple-test", SIMPLE_REGEX));
        assertNotThrown(() -> validator.assertRegex("simple_test", SIMPLE_REGEX));
        assertNotThrown(() -> validator.assertRegex("SIMpleTest", SIMPLE_REGEX));
        assertNotThrown(() -> validator.assertRegex("test", SIMPLE_REGEX));
        assertNotThrown(() -> validator.assertRegex("test@test.com", Validator.EMAIL_REGEX));
        assertNotThrown(() -> validator.assertRegex("test@mail.si", Validator.EMAIL_REGEX));
        assertNotThrown(() -> validator.assertRegex("test.test@mail.com", Validator.EMAIL_REGEX));
        assertNotThrown(() -> validator.assertRegex("test_test@mail.com", Validator.EMAIL_REGEX));
        
        // Assert thrown exception contains proper fields
        assertExceptionFields(
            () -> validator.assertRegex("123", SIMPLE_REGEX),
            () -> validator.assertRegex("123", SIMPLE_REGEX, FIELD_NAME),
            () -> validator.assertRegex("123", SIMPLE_REGEX, FIELD_NAME, ENTITY_NAME),
            Rest.HttpStatus.VALIDATION_FAILED
        );
    }
    
    @Test
    public void email() {
        // Assert invalid values are rejected
        assertThrows(ValidationException.class, () -> validator.assertEmail(null));
        assertThrows(ValidationException.class, () -> validator.assertEmail("te st@test.com"));
        assertThrows(ValidationException.class, () -> validator.assertEmail("test@te st.com"));
        assertThrows(ValidationException.class, () -> validator.assertEmail("test@test.c om"));
        assertThrows(ValidationException.class, () -> validator.assertEmail("test"));
        
        // Assert valid values are not rejected
        assertNotThrown(() -> validator.assertEmail("test@test.com"));
        assertNotThrown(() -> validator.assertEmail("test@mail.si"));
        assertNotThrown(() -> validator.assertEmail("test.test@mail.com"));
        assertNotThrown(() -> validator.assertEmail("test_test@mail.com"));
        
        // Assert thrown exception contains proper fields
        assertExceptionFields(
            () -> validator.assertEmail("test"),
            () -> validator.assertEmail("test", FIELD_NAME),
            () -> validator.assertEmail("test", FIELD_NAME, ENTITY_NAME),
            Rest.HttpStatus.VALIDATION_FAILED
        );
    }
    
    private Date dateInPast;
    private Date dateInFuture;
    
    @Before
    public void initDates() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 12, 0, 0);
        this.dateInPast = calendar.getTime();
        
        calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 10);
        this.dateInFuture = calendar.getTime();
    }
    
    @Test
    public void notBefore() {
        Date now = new Date();
        
        // Assert test values are correct
        assertTrue(now.before(dateInFuture));
        assertTrue(now.after(dateInPast));
        
        // Assert invalid values are rejected
        assertThrows(ValidationException.class, () -> validator.assertNotBefore(null, dateInFuture));
        assertThrows(ValidationException.class, () -> validator.assertNotBefore(null, dateInPast));
        assertThrows(ValidationException.class, () -> validator.assertNotBefore(now, null));
        assertThrows(ValidationException.class, () -> validator.assertNotBefore(null, null));
        assertThrows(ValidationException.class, () -> validator.assertNotBefore(now, dateInFuture));
        
        // Assert valid values are not rejected
        assertNotThrown(() -> validator.assertNotBefore(now, dateInPast));
        
        // Assert thrown exception contains proper fields
        assertExceptionFields(
            () -> validator.assertNotBefore(now, dateInFuture),
            () -> validator.assertNotBefore(now, dateInFuture, FIELD_NAME),
            () -> validator.assertNotBefore(now, dateInFuture, FIELD_NAME, ENTITY_NAME),
            Rest.HttpStatus.VALIDATION_FAILED
        );
    }
    
    @Test
    public void notAfter() {
        Date now = new Date();
        
        // Assert test values are correct
        assertTrue(now.before(dateInFuture));
        assertTrue(now.after(dateInPast));
        
        // Assert invalid values are rejected
        assertThrows(ValidationException.class, () -> validator.assertNotAfter(null, dateInPast));
        assertThrows(ValidationException.class, () -> validator.assertNotAfter(null, dateInFuture));
        assertThrows(ValidationException.class, () -> validator.assertNotAfter(now, null));
        assertThrows(ValidationException.class, () -> validator.assertNotAfter(null, null));
        assertThrows(ValidationException.class, () -> validator.assertNotAfter(now, dateInPast));
        
        // Assert valid values are not rejected
        assertNotThrown(() -> validator.assertNotAfter(now, dateInFuture));
        
        // Assert thrown exception contains proper fields
        assertExceptionFields(
            () -> validator.assertNotBefore(now, dateInPast),
            () -> validator.assertNotBefore(now, dateInPast, FIELD_NAME),
            () -> validator.assertNotBefore(now, dateInPast, FIELD_NAME, ENTITY_NAME),
            Rest.HttpStatus.VALIDATION_FAILED
        );
    }
    
    private void assertExceptionFields(ValidationExecutor simple,
                                       ValidationExecutor field,
                                       ValidationExecutor entity,
                                       int expectedStatus) {
        try {
            simple.execute();
        } catch (ValidationException e) {
            assertNull(e.getResponse().getField());
            assertNull(e.getResponse().getEntity());
            assertEquals((Integer) expectedStatus, e.getResponse().getStatus());
        }
        
        try {
            field.execute();
        } catch (ValidationException e) {
            assertEquals(FIELD_NAME, e.getResponse().getField());
            assertNull(e.getResponse().getEntity());
            assertEquals((Integer) expectedStatus, e.getResponse().getStatus());
        }
        
        try {
            entity.execute();
        } catch (ValidationException e) {
            assertEquals(FIELD_NAME, e.getResponse().getField());
            assertEquals(ENTITY_NAME, e.getResponse().getEntity());
            assertEquals((Integer) expectedStatus, e.getResponse().getStatus());
        }
    }
    
    private void assertNotThrown(ValidationExecutor func) {
        try {
            func.execute();
        } catch (ValidationException e) {
            fail("Validation exception was thrown!");
        }
    }
    
}
