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
package com.mjamsek.rest.exceptions;

import static com.mjamsek.rest.Rest.HttpStatus;

import com.mjamsek.rest.exceptions.dto.ExceptionResponse;

/**
 * Exception to be thrown on failed validation
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class ValidationException extends RestException {
    
    public ValidationException(String code) {
        super(code);
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(HttpStatus.VALIDATION_FAILED);
    }
    
    public ValidationException withStatus(int status) {
        this.response.setStatus(status);
        return this;
    }
    
    public ValidationException withField(String field) {
        this.response.setField(field);
        return this;
    }
    
    public ValidationException withEntity(String entity) {
        this.response.setEntity(entity);
        return this;
    }
    
    public ValidationException withDescription(String description) {
        this.response.setMessage(description);
        return this;
    }
    
    public ValidationException withMoreInfo(String moreInfo) {
        this.response.setMoreInfo(moreInfo);
        return this;
    }
    
    public ValidationException isValidationError() {
        this.response.setStatus(HttpStatus.VALIDATION_FAILED);
        return this;
    }
    
    public ValidationException isBadRequest() {
        this.response.setStatus(HttpStatus.BAD_REQUEST);
        return this;
    }
    
}
