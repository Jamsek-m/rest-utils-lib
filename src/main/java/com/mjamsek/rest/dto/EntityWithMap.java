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
package com.mjamsek.rest.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Data wrapper for entity with additional params saved in map
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class EntityWithMap<E> {
    
    @JsonProperty("entity")
    private E entity;
    
    @JsonIgnore
    private final Map<String, Serializable> options = new HashMap<>();
    
    public E getEntity() {
        return entity;
    }
    
    public void setEntity(E entity) {
        this.entity = entity;
    }
    
    @JsonAnyGetter
    public Map<String, Serializable> getOptions() {
        return options;
    }
    
    @JsonAnySetter
    public void setOptions(String name, Serializable value) {
        this.options.put(name, value);
    }
}
