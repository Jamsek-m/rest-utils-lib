package com.mjamsek.rest.services;

import com.mjamsek.rest.exceptions.ValidationException;

public interface Validator {
    
    /**
     * Asserts value is not null
     * @param value value to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotNull(Object value) throws ValidationException;
    
    /**
     * Asserts value is not null
     * @param value value to be checked
     * @param fieldName name of a field to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotNull(Object value, String fieldName) throws ValidationException;
    
    /**
     * Asserts value is not null
     * @param value value to be checked
     * @param fieldName name of a field to be checked
     * @param entity name of entity to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotNull(Object value, String fieldName, String entity) throws ValidationException;
    
    /**
     * Asserts value has valid string
     * @param value value to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotBlank(String value) throws ValidationException;
    
    /**
     * Asserts value has valid string
     * @param value value to be checked
     * @param fieldName name of a field to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotBlank(String value, String fieldName) throws ValidationException;
    
    /**
     * Asserts value has valid string
     * @param value value to be checked
     * @param fieldName name of a field to be checked
     * @param entity name of entity to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotBlank(String value, String fieldName, String entity) throws ValidationException;
    
    /**
     * Checks value matches regex expression.
     * @param value value to be checked
     * @param regex regex expression to be searched
     * @throws ValidationException on mismatch
     */
    void assertRegex(String value, String regex) throws ValidationException;
    
    /**
     * Checks value matches regex expression.
     * @param value value to be checked
     * @param regex regex expression to be searched
     * @param fieldName name of a field to be checked
     * @throws ValidationException on mismatch
     */
    void assertRegex(String value, String regex, String fieldName) throws ValidationException;
    
    /**
     * Checks value matches regex expression.
     * @param value value to be checked
     * @param regex regex expression to be searched
     * @param fieldName name of a field to be checked
     * @param entity name of entity to be checked
     * @throws ValidationException on mismatch
     */
    void assertRegex(String value, String regex, String fieldName, String entity) throws ValidationException;
    
}
