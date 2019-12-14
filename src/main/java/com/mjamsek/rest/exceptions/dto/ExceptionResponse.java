package com.mjamsek.rest.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    protected Integer status;
    protected String message;
    protected String code;
    protected String entity;
    protected String field;
    protected String moreInfo;
    protected Object[] params;
    protected Map<String, Object> additionalData = new HashMap<>();
    
    public Response createResponse() {
        ExceptionResponse body = new ExceptionResponse();
        body.setStatus(this.status);
        body.setMessage(this.message);
        body.setCode(this.code);
        body.setEntity(this.entity);
        body.setField(this.field);
        body.setMoreInfo(this.moreInfo);
        body.setAdditionalData(this.additionalData);
        return Response.status(this.status).entity(body).build();
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getEntity() {
        return entity;
    }
    
    public void setEntity(String entity) {
        this.entity = entity;
    }
    
    public String getField() {
        return field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
    
    public String getMoreInfo() {
        return moreInfo;
    }
    
    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
    
    public Object[] getParams() {
        return params;
    }
    
    public void setParams(Object... params) {
        this.params = params;
    }
    
    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }
    
    public void setAdditionalData(Map<String, Object> additionalData) {
        this.additionalData = additionalData;
    }
}
