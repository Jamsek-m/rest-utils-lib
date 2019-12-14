package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class BadRequestException extends RestException {
    
    public BadRequestException(String code) {
        super(code, Response.Status.BAD_REQUEST.getStatusCode());
    }
    
    public BadRequestException(String code, Object... params) {
        super(code, Response.Status.BAD_REQUEST.getStatusCode());
        super.setParams(params);
    }
}
