package com.mjamsek.rest.exceptions.dto;

import javax.ws.rs.core.Response;

public class SpecificExcResp extends ExceptionResponse {
    
    private String testFld;
    
    @Override
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
    
    public String getTestFld() {
        return testFld;
    }
    
    public void setTestFld(String testFld) {
        this.testFld = testFld;
    }
}
