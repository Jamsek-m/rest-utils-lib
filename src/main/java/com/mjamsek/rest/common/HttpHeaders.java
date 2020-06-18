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
package com.mjamsek.rest.common;

/**
 * Constants for special HTTP headers
 *
 * @author Miha Jamsek
 * @since 1.0.0
 */
public class HttpHeaders {
    
    public static final String X_SERVICE_NAME = "X-Service-Name";
    public static final String X_SERVICE_VERSION = "X-Service-Version";
    public static final String X_SERVICE_ENV = "X-Service-Env";
    public static final String X_REQUEST_ID = "X-Request-Id";
    
    public static final String X_TOTAL_COUNT = "X-Total-Count";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String AUTHORIZATION = "Authorization";
    
    public static final String X_POWERED_BY = "X-Powered-By";
    
    public static final String X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";
    public static final String X_XSS_PROTECTION = "X-XSS-Protection";
    public static final String X_FRAME_OPTIONS = "X-Frame-Options";
    public static final String STRICT_TRANSPORT_SECURITY = "Strict-Transport-Security";
    public static final String CONTENT_SECURITY_POLICY = "Content-Security-Policy";
    
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String TIMING_ALLOW_ORIGIN = "Timing-Allow-Origin";
    
}
