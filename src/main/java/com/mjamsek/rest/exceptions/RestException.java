package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class RestException extends RuntimeException {
    
    private int status;
    
    public RestException(String message) {
        super(message);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }
    public RestException(String message, Throwable cause) {
        super(message, cause);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }
    
    public RestException(String message, Response.Status status) {
        super(message);
        this.status = status.getStatusCode();
    }
    
    public RestException(String message, int status) {
        super(message);
        this.status = status;
    }
    
    public RestException(String message, Response.Status status, Throwable cause) {
        super(message, cause);
        this.status = status.getStatusCode();
    }
    
    public RestException(String message, int status, Throwable cause) {
        super(message, cause);
        this.status = status;
    }
    
    public int getStatus() {
        return this.status;
    }
}
