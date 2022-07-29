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
    
    private static final String NULL_PROP_ERROR_CODE = "validation.error.property.null";
    private static final String BLANK_PROP_ERROR_CODE = "validation.error.property.blank";
    private static final String DATE_AFTER_ERROR_CODE = "validation.error.property.not-after.false";
    private static final String DATE_BEFORE_ERROR_CODE = "validation.error.property.not-before.false";
    private static final String REGEX_ERROR_CODE = "validation.error.property.regex.false";
    private static final String DATE_AFTER_ERROR_DESCRIPTION = "Value must not be after notAfter!";
    private static final String DATE_BEFORE_ERROR_DESCRIPTION = "Value must not be before notBefore!";
    
    @Override
    public void assertNotNull(Object value) throws ValidationException {
        ValidationException exc = new ValidationException(NULL_PROP_ERROR_CODE)
            .withDescription("Object could not be serialized due to missing values!")
            .isBadRequest();
        exc.setParams(NULL_PROP_ERROR_CODE);
        assertNotNull(value, exc);
    }
    
    @Override
    public void assertNotNull(Object value, String fieldName) throws ValidationException {
        ValidationException exc = new ValidationException(NULL_PROP_ERROR_CODE)
            .withDescription(String.format("Object could not be serialized! Field '%s' must not be null!", fieldName))
            .withField(fieldName)
            .isBadRequest();
        exc.setParams(NULL_PROP_ERROR_CODE, fieldName);
        assertNotNull(value, exc);
    }
    
    @Override
    public void assertNotNull(Object value, String fieldName, String entity) throws ValidationException {
        ValidationException exc = new ValidationException(NULL_PROP_ERROR_CODE)
            .withDescription(String.format("Object could not be serialized! Field '%s' of entity '%s' must not be null!", fieldName, entity))
            .withField(fieldName)
            .withEntity(entity)
            .isBadRequest();
        exc.setParams(NULL_PROP_ERROR_CODE, fieldName, entity);
        assertNotNull(value, exc);
    }
    
    private void assertNotNull(Object value, ValidationException exc) throws ValidationException {
        if (value == null) {
            throw exc;
        }
    }
    
    @Override
    public void assertNotBlank(String value) throws ValidationException {
        ValidationException exc = new ValidationException(BLANK_PROP_ERROR_CODE)
            .withDescription("Object could not be serialized due to missing values!")
            .isBadRequest();
        exc.setParams(BLANK_PROP_ERROR_CODE);
        assertNotBlank(value, exc);
    }
    
    @Override
    public void assertNotBlank(String value, String fieldName) throws ValidationException {
        ValidationException exc = new ValidationException(BLANK_PROP_ERROR_CODE)
            .withDescription(String.format("Object could not be serialized! Field '%s' must not be null!", fieldName))
            .withField(fieldName)
            .isBadRequest();
        exc.setParams(BLANK_PROP_ERROR_CODE, fieldName);
        assertNotBlank(value, exc);
    }
    
    @Override
    public void assertNotBlank(String value, String fieldName, String entity) throws ValidationException {
        ValidationException exc = new ValidationException(BLANK_PROP_ERROR_CODE)
            .withDescription(String.format("Object could not be serialized! Field '%s' of entity '%s' must not be null!", fieldName, entity))
            .withField(fieldName)
            .withEntity(entity)
            .isBadRequest();
        exc.setParams(BLANK_PROP_ERROR_CODE, fieldName, entity);
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
        ValidationException exc = new ValidationException(REGEX_ERROR_CODE)
            .withDescription("Value does not match required form!")
            .isValidationError();
        exc.setParams(REGEX_ERROR_CODE);
        assertRegex(value, regex, exc);
    }
    
    @Override
    public void assertRegex(String value, String regex, String fieldName) throws ValidationException {
        assertNotNull(value);
        ValidationException exc = new ValidationException(REGEX_ERROR_CODE)
            .withDescription(String.format("Value does not match required form! Field '%s' must be in required form!", fieldName))
            .withField(fieldName)
            .isValidationError();
        exc.setParams(REGEX_ERROR_CODE, fieldName);
        assertRegex(value, regex, exc);
    }
    
    @Override
    public void assertRegex(String value, String regex, String fieldName, String entity) throws ValidationException {
        assertNotNull(value);
        ValidationException exc = new ValidationException(REGEX_ERROR_CODE)
            .withDescription(String.format("Value does not match required form! Field '%s' of entity '%s' must be in required form!", fieldName, entity))
            .withField(fieldName)
            .withEntity(entity)
            .isValidationError();
        exc.setParams(REGEX_ERROR_CODE, fieldName, entity);
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
        ValidationException exc = new ValidationException(DATE_BEFORE_ERROR_CODE)
            .withDescription(DATE_BEFORE_ERROR_DESCRIPTION)
            .isValidationError();
        exc.setParams(NULL_PROP_ERROR_CODE);
        assertNotBefore(value, notBefore, exc);
    }
    
    @Override
    public void assertNotBefore(Date value, Date notBefore, String fieldName) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notBefore);
        ValidationException exc = new ValidationException(DATE_BEFORE_ERROR_CODE)
            .withDescription(DATE_BEFORE_ERROR_DESCRIPTION)
            .withField(fieldName)
            .isValidationError();
        exc.setParams(NULL_PROP_ERROR_CODE);
        assertNotBefore(value, notBefore, exc);
    }
    
    @Override
    public void assertNotBefore(Date value, Date notBefore, String fieldName, String entity) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notBefore);
        ValidationException exc = new ValidationException(DATE_BEFORE_ERROR_CODE)
            .withDescription(DATE_BEFORE_ERROR_DESCRIPTION)
            .withField(fieldName)
            .withEntity(entity)
            .isValidationError();
        exc.setParams(NULL_PROP_ERROR_CODE);
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
        ValidationException exc = new ValidationException(DATE_AFTER_ERROR_CODE)
            .withDescription(DATE_AFTER_ERROR_DESCRIPTION)
            .isValidationError();
        exc.setParams(NULL_PROP_ERROR_CODE);
        assertNotAfter(value, notAfter, exc);
    }
    
    @Override
    public void assertNotAfter(Date value, Date notAfter, String fieldName) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notAfter);
        ValidationException exc = new ValidationException(DATE_AFTER_ERROR_CODE)
            .withDescription(DATE_AFTER_ERROR_DESCRIPTION)
            .withField(fieldName)
            .isValidationError();
        exc.setParams(NULL_PROP_ERROR_CODE);
        assertNotAfter(value, notAfter, exc);
    }
    
    @Override
    public void assertNotAfter(Date value, Date notAfter, String fieldName, String entity) throws ValidationException {
        assertNotNull(value);
        assertNotNull(notAfter);
        ValidationException exc = new ValidationException(DATE_AFTER_ERROR_CODE)
            .withDescription(DATE_AFTER_ERROR_DESCRIPTION)
            .withField(fieldName)
            .withEntity(entity)
            .isValidationError();
        exc.setParams(NULL_PROP_ERROR_CODE);
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
