package com.mjamsek.rest.exceptions.dto;

import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 * @deprecated Test class, released by accident. Should not be used.
 */
@Deprecated(since = "2.5.0", forRemoval = true)
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
        body.setAdditionalData(new HashMap<>());
        return Response.status(this.status).entity(body).build();
    }
    
    public String getTestFld() {
        return testFld;
    }
    
    public void setTestFld(String testFld) {
        this.testFld = testFld;
    }
}
