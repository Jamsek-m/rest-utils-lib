package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class UnauthorizedException extends RestException {
    
    public UnauthorizedException(String code) {
        super(code, Response.Status.UNAUTHORIZED.getStatusCode());
    }
}
