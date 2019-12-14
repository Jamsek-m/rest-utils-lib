package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class NotFoundException extends RestException {
    
    public NotFoundException(String code) {
        super(code, Response.Status.NOT_FOUND.getStatusCode());
    }
    
    public NotFoundException(String code, Class<?> entityClass, String entityId) {
        super(code, Response.Status.NOT_FOUND.getStatusCode());
        super.setParams(entityClass.getSimpleName(), entityId);
    }
}
