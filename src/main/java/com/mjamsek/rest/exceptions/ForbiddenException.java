package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ForbiddenException extends RestException {
    
    public ForbiddenException(String message) {
        super(message, Response.Status.FORBIDDEN.getStatusCode());
    }
}
