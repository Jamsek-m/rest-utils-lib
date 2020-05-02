package com.mjamsek.rest.utils;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Resources {
    
    public static URI resourceUri(UriInfo uriInfo, String... paths) {
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        for (String path : paths) {
            uriBuilder = uriBuilder.path(path);
        }
        return uriBuilder.build();
    }
    
}
