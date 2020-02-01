package com.mjamsek.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityWithOptions<E, O> {
    
    private E entity;
    
    private O options;
    
    public E getEntity() {
        return entity;
    }
    
    public void setEntity(E entity) {
        this.entity = entity;
    }
    
    public O getOptions() {
        return options;
    }
    
    public void setOptions(O options) {
        this.options = options;
    }
}
