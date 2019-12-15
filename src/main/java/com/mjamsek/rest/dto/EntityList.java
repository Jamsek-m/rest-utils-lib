package com.mjamsek.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class EntityList<E> {
    
    private long count;
    
    private List<E> entityList;
    
    public EntityList() {
        this.entityList = new ArrayList<>();
    }
    
    public EntityList(List<E> list) {
        this.entityList = list;
        this.count = list.size();
    }
    
    public EntityList(List<E> list, long count) {
        this.entityList = list;
        this.count = count;
    }
    
    public long getCount() {
        return count;
    }
    
    public void setCount(long count) {
        this.count = count;
    }
    
    public List<E> getEntityList() {
        return entityList;
    }
    
    public void setEntityList(List<E> entityList) {
        this.entityList = entityList;
    }
}
