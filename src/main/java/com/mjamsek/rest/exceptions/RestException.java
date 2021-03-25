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
package com.mjamsek.rest.exceptions;

import com.mjamsek.rest.exceptions.dto.ExceptionResponse;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for exception
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class RestException extends RuntimeException {
    
    protected final int status;
    
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
    
    /**
     * Replaces exception's response and loses all previously set values
     * @param response new response object
     * @return <code>this</code> instance
     */
    public RestException replaceResponse(ExceptionResponse response) {
        this.response = response;
        return this;
    }
    
    public RestException addAdditionalData(String dataKey, Object dataValue) {
        if (this.response.getAdditionalData() == null) {
            this.response.setAdditionalData(new HashMap<>());
        }
        this.response.getAdditionalData().put(dataKey, dataValue);
        return this;
    }
    
    public RestException setAdditionalData(Map<String, Object> additionalData) {
        this.response.setAdditionalData(additionalData);
        return this;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public ExceptionResponse getResponse() {
        return this.response;
    }
}
