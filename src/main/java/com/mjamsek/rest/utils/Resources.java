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
package com.mjamsek.rest.utils;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Utility class for handling resources
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class Resources {
    
    private Resources() {
    
    }
    
    /**
     * Concatenates multiple paths into complete {@link java.net.URI}
     * @param uriInfo uri context
     * @param paths list of paths to be concatenated
     * @return concatenated paths into URI
     */
    public static URI resourceUri(UriInfo uriInfo, String... paths) {
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        for (String path : paths) {
            uriBuilder = uriBuilder.path(path);
        }
        return uriBuilder.build();
    }
    
}
