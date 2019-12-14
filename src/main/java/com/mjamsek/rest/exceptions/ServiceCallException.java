package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ServiceCallException extends RestException {
    
    private String serviceName;
    
    public ServiceCallException(String code) {
        super(code, Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
    }
    
    public ServiceCallException(String code, String service) {
        super(code, Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
        this.serviceName = service;
        super.setParams(service);
    }
    
    public ServiceCallException(String code, Throwable cause) {
        super(code, Response.Status.SERVICE_UNAVAILABLE.getStatusCode(), cause);
    }
    
    public ServiceCallException(String code, String service, Throwable cause) {
        super(code, Response.Status.SERVICE_UNAVAILABLE.getStatusCode(), cause);
        this.serviceName = service;
        super.setParams(service);
    }
    
    public String getServiceName() {
        return serviceName;
    }
}
