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

import java.util.Locale;

/**
 * Utility class for creating URL handle
 *
 * @author Miha Jamsek
 * @since 2.2.0
 */
public class HandleUtil {
    
    public static final String HANDLE_REGEX = "^[a-z0-9-_]+$";
    
    private HandleUtil() {
    
    }
    
    /**
     * Creates URL handle from given string
     * @param value string to be converted
     * @return URL safe string
     */
    public static String toHandle(String value) {
        value = value.toLowerCase(Locale.ROOT).trim();
        value = value.replaceAll(" +", " ");
        value = value.replaceAll("\\s", "-");
        return value.replaceAll("[^a-z0-9-_]", "");
    }
    
    /**
     * Checks if given string is valid handle
     * @param handle value to be verified
     * @return <code>true</code>, if value is valid handle, <code>false</code> otherwise
     */
    public static boolean validHandle(String handle) {
        return handle.matches(HANDLE_REGEX);
    }
}
