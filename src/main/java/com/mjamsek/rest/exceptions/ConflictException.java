package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ConflictException extends RestException {
    
    public ConflictException(String code) {
        super(code, Response.Status.CONFLICT.getStatusCode());
    }
    
    public ConflictException(String code, Throwable cause) {
        super(code, Response.Status.CONFLICT.getStatusCode());
        super.setCause(cause);
    }
    
    public ConflictException(String code, String entity) {
        super(code, Response.Status.CONFLICT.getStatusCode());
        super.setEntity(entity);
    }
    
    public ConflictException(String code, String entity, Throwable cause) {
        super(code, Response.Status.CONFLICT.getStatusCode());
        super.setEntity(entity);
        super.setCause(cause);
    }
    
    public ConflictException(String code, String entity, String field) {
        super(code, Response.Status.CONFLICT.getStatusCode(), field, entity);
    }
    
    public ConflictException(String code, String entity, String field, Throwable cause) {
        super(code, Response.Status.CONFLICT.getStatusCode(), field, entity);
        super.setCause(cause);
    }
}
