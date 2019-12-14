package com.mjamsek.rest.exceptions;

import com.mjamsek.rest.common.HttpStatus;
import com.mjamsek.rest.exceptions.dto.ExceptionResponse;


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
