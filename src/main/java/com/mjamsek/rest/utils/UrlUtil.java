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

/**
 * Utility class for manipulating URLs
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class UrlUtil {
    
    private UrlUtil() {
    
    }
    
    /**
     * Removes trailing slash in URL
     * @param url url to be trimmed
     * @return url trimmed of last slash
     */
    public static String removeTrailingSlash(String url) {
        if (url.endsWith("/")) {
            return url.substring(0, url.length() - 1);
        }
        return url;
    }
    
    /**
     * Removes leading slash in URL
     * @param url url to be trimmed
     * @return url trimmed of leading slash
     */
    public static String removeLeadingSlash(String url) {
        if (url.startsWith("/")) {
            return url.substring(1);
        }
        return url;
    }
    
    /**
     * Removes last part of url
     * @param url url to be trimmed
     * @return url without its last part
     * <pre>
     * {@code
     * UrlUtil.removeLastPath("/path/to/something/else");
     * // returns '/path/to/something/'
     * }
     * </pre>
     */
    public static String removeLastPath(String url) {
        if (!url.endsWith("/")) {
            int replaceIndex = url.lastIndexOf('/');
            return url.substring(0, replaceIndex + 1);
        }
        return url;
    }
    
}
