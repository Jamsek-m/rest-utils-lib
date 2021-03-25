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
package com.mjamsek.rest.services;

import com.mjamsek.rest.exceptions.ValidationException;

import java.util.Date;

/**
 * Validation service for common validation patterns
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public interface Validator {
    
    /**
     * RFC 5322 compliant regex
     *
     * @see <a href="http://google.com">https://www.ietf.org/rfc/rfc5322.txt</a>
     */
    String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    
    /**
     * Asserts value is not null
     *
     * @param value value to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotNull(Object value) throws ValidationException;
    
    /**
     * Asserts value is not null
     *
     * @param value     value to be checked
     * @param fieldName name of a field to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotNull(Object value, String fieldName) throws ValidationException;
    
    /**
     * Asserts value is not null
     *
     * @param value     value to be checked
     * @param fieldName name of a field to be checked
     * @param entity    name of entity to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotNull(Object value, String fieldName, String entity) throws ValidationException;
    
    /**
     * Asserts value has valid string
     *
     * @param value value to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotBlank(String value) throws ValidationException;
    
    /**
     * Asserts value has valid string
     *
     * @param value     value to be checked
     * @param fieldName name of a field to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotBlank(String value, String fieldName) throws ValidationException;
    
    /**
     * Asserts value has valid string
     *
     * @param value     value to be checked
     * @param fieldName name of a field to be checked
     * @param entity    name of entity to be checked
     * @throws ValidationException on validation failed
     */
    void assertNotBlank(String value, String fieldName, String entity) throws ValidationException;
    
    /**
     * Checks value matches regex expression.
     *
     * @param value value to be checked
     * @param regex regex expression to be searched
     * @throws ValidationException on mismatch or null value
     */
    void assertRegex(String value, String regex) throws ValidationException;
    
    /**
     * Checks value matches regex expression.
     *
     * @param value     value to be checked
     * @param regex     regex expression to be searched
     * @param fieldName name of a field to be checked
     * @throws ValidationException on mismatch or null value
     */
    void assertRegex(String value, String regex, String fieldName) throws ValidationException;
    
    /**
     * Checks value matches regex expression.
     *
     * @param value     value to be checked
     * @param regex     regex expression to be searched
     * @param fieldName name of a field to be checked
     * @param entity    name of entity to be checked
     * @throws ValidationException on mismatch or null value
     */
    void assertRegex(String value, String regex, String fieldName, String entity) throws ValidationException;
    
    /**
     * Checks <code>value</code> is not before <code>notBefore</code> in time
     *
     * @param value     value to be checked
     * @param notBefore first allowed date
     * @throws ValidationException if <code>value</code> is before <code>notBefore</code> in time or null args
     */
    void assertNotBefore(Date value, Date notBefore) throws ValidationException;
    
    /**
     * Checks <code>value</code> is not before <code>notBefore</code> in time
     *
     * @param value     value to be checked
     * @param notBefore first allowed date
     * @param fieldName name of a field to be checked
     * @throws ValidationException if <code>value</code> is before <code>notBefore</code> in time or null args
     */
    void assertNotBefore(Date value, Date notBefore, String fieldName) throws ValidationException;
    
    /**
     * Checks <code>value</code> is not before <code>notBefore</code> in time
     *
     * @param value     value to be checked
     * @param notBefore first allowed date
     * @param fieldName name of a field to be checked
     * @param entity    name of entity to be checked
     * @throws ValidationException if <code>value</code> is before <code>notBefore</code> in time or null args
     */
    void assertNotBefore(Date value, Date notBefore, String fieldName, String entity) throws ValidationException;
    
    /**
     * Checks <code>value</code> is not after <code>notAfter</code> in time
     *
     * @param value    value to be checked
     * @param notAfter last allowed date
     * @throws ValidationException if <code>value</code> is after <code>notAfter</code> in time or null args
     */
    void assertNotAfter(Date value, Date notAfter) throws ValidationException;
    
    /**
     * Checks <code>value</code> is not after <code>notAfter</code> in time
     *
     * @param value     value to be checked
     * @param notAfter  last allowed date
     * @param fieldName name of a field to be checked
     * @throws ValidationException if <code>value</code> is after <code>notAfter</code> in time or null args
     */
    void assertNotAfter(Date value, Date notAfter, String fieldName) throws ValidationException;
    
    /**
     * Checks <code>value</code> is not before <code>notAfter</code> in time
     *
     * @param value     value to be checked
     * @param notAfter  last allowed date
     * @param fieldName name of a field to be checked
     * @param entity    name of entity to be checked
     * @throws ValidationException if <code>value</code> is after <code>notAfter</code> in time or null args
     */
    void assertNotAfter(Date value, Date notAfter, String fieldName, String entity) throws ValidationException;
    
    /**
     * Checks value is in email format (RFC 5322)
     *
     * @param email value to be checked
     * @throws ValidationException if not in email format or email is blank
     * @see <a href="http://google.com">https://www.ietf.org/rfc/rfc5322.txt</a>
     */
    void assertEmail(String email) throws ValidationException;
    
    /**
     * Checks value is in email format (RFC 5322)
     *
     * @param email     value to be checked
     * @param fieldName name of a field to be checked
     * @throws ValidationException if not in email format or email is blank
     * @see <a href="http://google.com">https://www.ietf.org/rfc/rfc5322.txt</a>
     */
    void assertEmail(String email, String fieldName) throws ValidationException;
    
    /**
     * Checks value is in email format (RFC 5322)
     *
     * @param email     value to be checked
     * @param fieldName name of a field to be checked
     * @param entity    name of entity to be checked
     * @throws ValidationException if not in email format or email is blank
     * @see <a href="http://google.com">https://www.ietf.org/rfc/rfc5322.txt</a>
     */
    void assertEmail(String email, String fieldName, String entity) throws ValidationException;
}
