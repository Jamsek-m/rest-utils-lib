package com.mjamsek.rest.exceptions;

import javax.ws.rs.core.Response;

public class ServiceCallException extends RestException {
    
    private String serviceName;
    
    public ServiceCallException(String code, String service) {
        super(code, Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
        this.serviceName = service;
        super.setParams(service);
    }
    
    public ServiceCallException(String code, String service, Throwable cause) {
        super(code, Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
        super.setCause(cause);
        this.serviceName = service;
        super.setParams(service);
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    @Override
    public RestException setParams(Object... params) {
        return super.setParams(serviceName, params);
    }
}
