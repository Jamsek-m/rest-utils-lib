package com.mjamsek.rest.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;


public class EntityWithMap<E> {
    
    private E entity;
    
    @JsonIgnore
    private Map<String, Object> options = new HashMap<>();
    
    public E getEntity() {
        return entity;
    }
    
    public void setEntity(E entity) {
        this.entity = entity;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getOptions() {
        return options;
    }
    
    @JsonAnySetter
    public void setOptions(String name, Object value) {
        this.options.put(name, value);
    }
}
