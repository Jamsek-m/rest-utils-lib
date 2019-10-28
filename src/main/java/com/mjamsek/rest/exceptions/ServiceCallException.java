package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ServiceCallException extends RestException {
    
    private String serviceName;
    
    public ServiceCallException(String message) {
        super(message, Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
    }
    
    public ServiceCallException(String message, String service) {
        super(message, Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
        this.serviceName = service;
    }
    
    public ServiceCallException(String message, Throwable cause) {
        super(message, Response.Status.SERVICE_UNAVAILABLE.getStatusCode(), cause);
    }
    
    public ServiceCallException(String message, String service, Throwable cause) {
        super(message, Response.Status.SERVICE_UNAVAILABLE.getStatusCode(), cause);
        this.serviceName = service;
    }
    
    public String getServiceName() {
        return serviceName;
    }
}
