package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class NotFoundException extends RestException {
    
    public NotFoundException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
    
    public NotFoundException(Class<?> entityClass, String entityId) {
        super(String.format("Entity of type '%s' with id '%s' not found!", entityClass.getSimpleName(), entityId),
            Response.Status.NOT_FOUND);
    }
}
