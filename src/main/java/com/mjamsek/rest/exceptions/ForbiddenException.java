package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ForbiddenException extends RestException {
    
    public ForbiddenException(String code) {
        super(code, Response.Status.FORBIDDEN.getStatusCode());
    }
}
