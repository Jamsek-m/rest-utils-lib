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

import com.mjamsek.rest.Rest;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Data wrapper for entity list and count of all entities
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class EntityList<E> {
    
    private final long count;
    
    private final List<E> entities;
    
    private Long offset;
    
    private Long limit;
    
    public EntityList() {
        this.entities = new ArrayList<>();
        this.count = 0;
    }
    
    public EntityList(List<E> list) {
        this.entities = list;
        this.count = list.size();
    }
    
    public EntityList(List<E> list, long count) {
        this.entities = list;
        this.count = count;
    }
    
    public EntityList(List<E> list, long count, Long offset, Long limit) {
        this.entities = list;
        this.count = count;
        this.limit = limit;
        this.offset = offset;
    }
    
    public long getCount() {
        return count;
    }
    
    public List<E> getEntities() {
        return new ArrayList<>(entities);
    }
    
    public Long getOffset() {
        return offset;
    }
    
    public Long getLimit() {
        return limit;
    }
    
    public Response toResponse() {
        Response.ResponseBuilder builder = Response.ok(entities)
            .header(Rest.HttpHeaders.X_TOTAL_COUNT, count);
        
        if (limit != null) {
            builder = builder.header(Rest.HttpHeaders.X_LIMIT, limit);
        }
        if (offset != null) {
            builder = builder.header(Rest.HttpHeaders.X_OFFSET, offset);
        }
        
        return builder.build();
    }
    
}
