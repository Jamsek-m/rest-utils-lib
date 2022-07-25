/*
 *  Copyright (c) 2019 Miha Jamsek
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.mjamsek.rest.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Data wrapper for exception response
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse implements Serializable {
    protected Integer status;
    protected String message;
    protected String code;
    protected String entity;
    protected String field;
    protected String moreInfo;
    @JsonIgnore
    protected transient Object[] params;
    private Map<String, Serializable> additionalData;
    
    public Response createResponse() {
        ExceptionResponse body = new ExceptionResponse();
        body.setStatus(this.status);
        body.setMessage(this.message);
        body.setCode(this.code);
        body.setEntity(this.entity);
        body.setField(this.field);
        body.setMoreInfo(this.moreInfo);
        body.setAdditionalData(this.additionalData);
        return Response.status(this.status)
            .entity(body)
            .type(MediaType.APPLICATION_JSON)
            .build();
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
    
    public Map<String, Serializable> getAdditionalData() {
        return new HashMap<>(additionalData);
    }
    
    public void setAdditionalData(Map<String, Serializable> additionalData) {
        this.additionalData = new HashMap<>(additionalData);
    }
}
