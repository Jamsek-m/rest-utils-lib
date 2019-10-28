package com.mjamsek.rest.exceptions;

import com.mjamsek.rest.exceptions.dto.ExceptionResponse;

import javax.ws.rs.core.Response;

public class RestException extends RuntimeException {
    
    protected int status;
    
    protected ExceptionResponse response;
    
    public RestException(String code) {
        super(code);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
    }
    
    public RestException(String code, Throwable cause) {
        super(code, cause);
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
    
    public RestException(String code, Integer status, Throwable cause) {
        super(code, cause);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
    }
    
    public RestException(String code, String entity) {
        super(code);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
    }
    
    public RestException(String code, String entity, Throwable cause) {
        super(code, cause);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
    }
    
    public RestException(String code, Integer status, String entity) {
        super(code);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
    }
    
    public RestException(String code, Integer status, String entity, Throwable cause) {
        super(code, cause);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
    }
    
    public RestException(String code, String entity, String field) {
        super(code);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
        this.response.setField(field);
    }
    
    public RestException(String code, String entity, String field, Throwable cause) {
        super(code, cause);
        this.status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
        this.response.setField(field);
    }
    
    public RestException(String code, Integer status, String entity, String field) {
        super(code);
        this.status = status;
        this.response = new ExceptionResponse();
        this.response.setCode(code);
        this.response.setStatus(this.status);
        this.response.setEntity(entity);
        this.response.setField(field);
    }
    
    public RestException(String code, Integer status, String entity, String field, Throwable cause) {
        super(code, cause);
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
