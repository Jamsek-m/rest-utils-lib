/*
 *  Copyright (c) 2019 Miha Jamsek
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mjamsek.rest.services.impl;

import com.mjamsek.rest.exceptions.ValidationException;
import com.mjamsek.rest.services.Validator;

import java.util.Date;

/**
 * Validation service implementation for common validation patterns
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class ValidatorImpl implements Validator {
    
    @Override
    public void assertNotNull(Object value) throws ValidationException {
        ValidationException exc = new ValidationException("validation.error.property.null")
            .withDescription("Object could not be serialized due to missing values!")
            .isBadRequest();
        exc.setParams("validation.error.property.null");
        assertNotNull(value, exc);
    }
    
    @Override
    public void assertNotNull(Object value, String fieldName) throws ValidationException {
        ValidationException exc = new ValidationException("validation.error.property.null")
            .withDescription(String.format("Object could not be serialized! Field '%s' must not be null!", fieldName))
            .withField(fieldName)
            .isBadRequest();
        exc.setParams("validation.error.property.null", fieldName);
        assertNotNull(value, exc);
    }
    
    @Override
    public void assertNotNull(Object value, String fieldName, String entity) throws ValidationException {
        ValidationException exc = new ValidationException("validation.error.property.null")
            .withDescription(String.format("Object could not be serialized! Field '%s' of entity '%s' must not be null!", fieldName, entity))
            .withField(fieldName)
            .withEntity(entity)
            .isBadRequest();
        exc.setParams("validation.error.property.null", fieldName, entity);
        assertNotNull(value, exc);
    }
    
    private void assertNotNull(Object value, ValidationException exc) throws ValidationException {
        if (value == null) {
            throw exc;
        }
    }
    
    @Override
    public void assertNotBlank(String value) throws ValidationException {
        ValidationException exc = new ValidationException("validation.error.property.blank")
            .withDescription("Object could not be serialized due to missing values!")
            .isBadRequest();
        exc.setParams("validation.error.property.blank");
        assertNotBlank(value, exc);
    }
    
    @Override
    public void assertNotBlank(String value, String fieldName) throws ValidationException {
        ValidationException exc = new ValidationException("validation.error.property.blank")
            .withDescription(String.format("Object could not be serialized! Field '%s' must not be null!", fieldName))
            .withField(fieldName)
            .isBadRequest();
        exc.setParams("validation.error.property.blank", fieldName);
        assertNotBlank(value, exc);
    }
    
    @Override
    public void assertNotBlank(String value, String fieldName, String entity) throws ValidationException {
        ValidationException exc = new ValidationException("validation.error.property.blank")
            .withDescription(String.format("Object could not be serialized! Field '%s' of entity '%s' must not be null!", fieldName, entity))
            .withField(fieldName)
            .withEntity(entity)
            .isBadRequest();
        exc.setParams("validation.error.property.blank", fieldName, entity);
        assertNotBlank(value, exc);
    }
    
    private void assertNotBlank(String value, ValidationException exc) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            throw exc;
        }
    }
    
    @Override
    public void assertRegex(String value, String regex) throws ValidationException {
        assertNotNull(value);
        ValidationException exc = new ValidationException("validation.error.property.regex.false")
            .withDescription("Value does not match required form!")
            .isValidationError();
        exc.setParams("validation.error.property.regex.false");
        assertRegex(value, regex, exc);
    }
    
    @Override
    public void assertRegex(String value, String regex, String fieldName) throws ValidationException {
        assertNotNull(value);
        ValidationException exc = new ValidationException("validation.error.property.regex.false")
            .withDescription(String.format("Value does not match required form! Field '%s' must be in required form!", fieldName))
            .withField(fieldName)
            .isValidationError();
        exc.setParams("validation.error.property.regex.false", fieldName);
        assertRegex(value, regex, exc);
    }
    
    @Override
    public void assertRegex(String value, String regex, String fieldName, String entity) throws ValidationException {
        assertNotNull(value);
        ValidationException exc = new ValidationException("validation.error.property.regex.false")
            .withDescription(String.format("Value does not match required form! Field '%s' of entity '%s' must be in required form!", fieldName, entity))
            .withField(fieldName)
            .withEntity(entity)
            .isValidationError();
        exc.setParams("validation.error.property.regex.false", fieldName, entity);
        assertRegex(value, regex, exc);
    }
    
    private void assertRegex(String value, String regex, ValidationException exc) throws ValidationException {
        if (!value.matches(regex)) {
            throw exc;
        }
    }
    
    @Override
    public void assertNotBefore(Date value, Date notBefore) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notBefore);
        ValidationException exc = new ValidationException("validation.error.property.not-before.false")
            .withDescription("Value must not be before notBefore!")
            .isValidationError();
        exc.setParams("validation.error.property.null");
        assertNotBefore(value, notBefore, exc);
    }
    
    @Override
    public void assertNotBefore(Date value, Date notBefore, String fieldName) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notBefore);
        ValidationException exc = new ValidationException("validation.error.property.not-before.false")
            .withDescription("Value must not be before notBefore!")
            .withField(fieldName)
            .isValidationError();
        exc.setParams("validation.error.property.null");
        assertNotBefore(value, notBefore, exc);
    }
    
    @Override
    public void assertNotBefore(Date value, Date notBefore, String fieldName, String entity) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notBefore);
        ValidationException exc = new ValidationException("validation.error.property.not-before.false")
            .withDescription("Value must not be before notBefore!")
            .withField(fieldName)
            .withEntity(entity)
            .isValidationError();
        exc.setParams("validation.error.property.null");
        assertNotBefore(value, notBefore, exc);
    }
    
    private void assertNotBefore(Date value, Date notBefore, ValidationException exc) throws ValidationException {
        if (value.before(notBefore)) {
            throw exc;
        }
    }
    
    @Override
    public void assertNotAfter(Date value, Date notAfter) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notAfter);
        ValidationException exc = new ValidationException("validation.error.property.not-after.false")
            .withDescription("Value must not be after notAfter!")
            .isValidationError();
        exc.setParams("validation.error.property.null");
        assertNotAfter(value, notAfter, exc);
    }
    
    @Override
    public void assertNotAfter(Date value, Date notAfter, String fieldName) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notAfter);
        ValidationException exc = new ValidationException("validation.error.property.not-after.false")
            .withDescription("Value must not be after notAfter!")
            .withField(fieldName)
            .isValidationError();
        exc.setParams("validation.error.property.null");
        assertNotAfter(value, notAfter, exc);
    }
    
    @Override
    public void assertNotAfter(Date value, Date notAfter, String fieldName, String entity) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notAfter);
        ValidationException exc = new ValidationException("validation.error.property.not-after.false")
            .withDescription("Value must not be after notAfter!")
            .withField(fieldName)
            .withEntity(entity)
            .isValidationError();
        exc.setParams("validation.error.property.null");
        assertNotAfter(value, notAfter, exc);
    }
    
    private void assertNotAfter(Date value, Date notAfter, ValidationException exc) throws ValidationException {
        if (value.after(notAfter)) {
            throw exc;
        }
    }
    
    @Override
    public void assertEmail(String email) throws ValidationException {
        assertNotBlank(email);
        assertRegex(email, Validator.EMAIL_REGEX);
    }
    
    @Override
    public void assertEmail(String email, String fieldName) throws ValidationException {
        assertNotBlank(email);
        assertRegex(email, Validator.EMAIL_REGEX, fieldName);
    }
    
    @Override
    public void assertEmail(String email, String fieldName, String entity) throws ValidationException {
        assertNotBlank(email);
        assertRegex(email, Validator.EMAIL_REGEX, fieldName, entity);
    }
    
}
