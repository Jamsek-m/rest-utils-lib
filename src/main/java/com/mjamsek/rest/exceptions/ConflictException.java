package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ConflictException extends RestException {
    
    public ConflictException(String code) {
        super(code, Response.Status.CONFLICT.getStatusCode());
    }
    
    public ConflictException(String code, Throwable cause) {
        super(code, Response.Status.CONFLICT.getStatusCode(), cause);
    }
    
    public ConflictException(String code, String entity) {
        super(code, Response.Status.CONFLICT.getStatusCode(), entity);
    }
    
    public ConflictException(String code, String entity, Throwable cause) {
        super(code, Response.Status.CONFLICT.getStatusCode(), entity, cause);
    }
    
    public ConflictException(String code, String entity, String field) {
        super(code, Response.Status.CONFLICT.getStatusCode(), entity, field);
    }
    
    public ConflictException(String code, String entity, String field, Throwable cause) {
        super(code, Response.Status.CONFLICT.getStatusCode(), entity, field, cause);
    }
}
