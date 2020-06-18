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

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

/**
 * Validation service for common validation patterns
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
@ApplicationScoped
public class ValidatorImpl implements Validator {
    
    @Override
    public void assertNotNull(Object value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("validation.error.property.null")
                .withDescription("Object could not be serialized due to missing values!")
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.null");
        }
    }
    
    @Override
    public void assertNotNull(Object value, String fieldName) throws ValidationException {
        if (value == null) {
            throw new ValidationException("validation.error.property.null")
                .withDescription(String.format("Object could not be serialized! Field '%s' must not be null!", fieldName))
                .withField(fieldName)
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.null", fieldName);
        }
    }
    
    @Override
    public void assertNotNull(Object value, String fieldName, String entity) throws ValidationException {
        if (value == null) {
            throw new ValidationException("validation.error.property.null")
                .withDescription(String.format("Object could not be serialized! Field '%s' of entity '%s' must not be null!", fieldName, entity))
                .withField(fieldName)
                .withEntity(entity)
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.null", fieldName, entity);
        }
    }
    
    @Override
    public void assertNotBlank(String value) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException("validation.error.property.blank")
                .withDescription("Object could not be serialized due to missing values!")
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.blank");
        }
    }
    
    @Override
    public void assertNotBlank(String value, String fieldName) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException("validation.error.property.blank")
                .withDescription(String.format("Object could not be serialized! Field '%s' must not be null!", fieldName))
                .withField(fieldName)
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.blank", fieldName);
        }
    }
    
    @Override
    public void assertNotBlank(String value, String fieldName, String entity) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException("validation.error.property.blank")
                .withDescription(String.format("Object could not be serialized! Field '%s' of entity '%s' must not be null!", fieldName, entity))
                .withField(fieldName)
                .withEntity(entity)
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.blank", fieldName, entity);
        }
    }
    
    @Override
    public void assertRegex(String value, String regex) throws ValidationException {
        if (!value.matches(regex)) {
            throw new ValidationException("validation.error.property.regex.false")
                .withDescription("Value does not match required form!")
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.regex.false");
        }
    }
    
    @Override
    public void assertRegex(String value, String regex, String fieldName) throws ValidationException {
        if (!value.matches(regex)) {
            throw new ValidationException("validation.error.property.regex.false")
                .withDescription(String.format("Value does not match required form! Field '%s' must be in required form!", fieldName))
                .withField(fieldName)
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.regex.false", fieldName);
        }
    }
    
    @Override
    public void assertRegex(String value, String regex, String fieldName, String entity) throws ValidationException {
        if (!value.matches(regex)) {
            throw new ValidationException("validation.error.property.regex.false")
                .withDescription(String.format("Value does not match required form! Field '%s' of entity '%s' must be in required form!", fieldName, entity))
                .withField(fieldName)
                .withEntity(entity)
                .withStatus(Response.Status.BAD_REQUEST.getStatusCode())
                .setParams("validation.error.property.regex.false", fieldName, entity);
        }
    }
    
}
