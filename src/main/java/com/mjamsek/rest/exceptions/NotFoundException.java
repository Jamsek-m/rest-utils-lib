package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class NotFoundException extends RestException {
    
    public NotFoundException(String message) {
        super(message, Response.Status.NOT_FOUND.getStatusCode());
    }
    
    public NotFoundException(Class<?> entityClass, String entityId) {
        super("exception.not-found.clazz", Response.Status.NOT_FOUND.getStatusCode());
        this.setParams(entityClass.getSimpleName(), entityId);
    }
}
