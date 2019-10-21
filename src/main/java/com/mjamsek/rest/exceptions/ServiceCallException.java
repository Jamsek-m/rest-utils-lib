package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ServiceCallException extends RestException {
    
    private String serviceName;
    
    public ServiceCallException(String message) {
        super(message, Response.Status.SERVICE_UNAVAILABLE);
    }
    
    public ServiceCallException(String message, String service) {
        super(message, Response.Status.SERVICE_UNAVAILABLE);
        this.serviceName = service;
    }
    
    public ServiceCallException(String message, Throwable cause) {
        super(message, Response.Status.SERVICE_UNAVAILABLE, cause);
    }
    
    public ServiceCallException(String message, String service, Throwable cause) {
        super(message, Response.Status.SERVICE_UNAVAILABLE, cause);
        this.serviceName = service;
    }
    
    public String getServiceName() {
        return serviceName;
    }
}
