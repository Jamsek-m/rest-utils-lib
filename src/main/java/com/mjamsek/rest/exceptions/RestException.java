package com.mjamsek.rest.exceptions;

import com.mjamsek.rest.exceptions.dto.ExceptionResponse;

import javax.ws.rs.core.Response;

public class RestException extends RuntimeException {
    
    protected int status;
    
    protected ExceptionResponse response;
    
    protected Throwable cause;
    
    public RestException(String code) {
        super(code);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
    }
    
    public RestException(String code, Integer status) {
        super(code);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
    }
    
    public RestException(String code, String field) {
        super(code);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setField(field);
    }
    
    public RestException(String code, Integer status, String field) {
        super(code);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setField(field);
    }
    
    public RestException(String code, String field, String entity) {
        super(code);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
        this.response.setField(field);
    }
    
    public RestException(String code, Integer status, String field, String entity) {
        super(code);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
        this.response.setField(field);
    }
    
    public RestException setMoreInfo(String moreInfo) {
        this.response.setMoreInfo(moreInfo);
        return this;
    }
    
    public RestException setMessage(String message) {
        this.response.setMessage(message);
        return this;
    }
    
    public RestException setEntity(String entity) {
        this.response.setEntity(entity);
        return this;
    }
    
    public RestException setCause(Throwable cause) {
        this.cause = cause;
        return this;
    }
    
    public RestException setParams(Object... params) {
        this.response.setParams(params);
        return this;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public ExceptionResponse getResponse() {
        return this.response;
    }
}
