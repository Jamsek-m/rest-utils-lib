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
package com.mjamsek.rest.factories;

import com.mjamsek.rest.services.Localizator;
import com.mjamsek.rest.services.impl.LocalizatorImpl;

/**
 * Factory for producing {@link Localizator}
 *
 * @author Miha Jamsek
 * @since 2.0.0
 */
public class LocalizatorFactory {
    
    private LocalizatorFactory() {
    
    }
    
    public static Localizator getNewInstance() {
        return new LocalizatorImpl();
    }
    
}
