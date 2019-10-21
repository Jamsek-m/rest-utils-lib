package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class UnauthorizedException extends RestException {
    
    public UnauthorizedException(String message) {
        super(message, Response.Status.UNAUTHORIZED);
    }
}
