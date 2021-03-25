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
package com.mjamsek.rest.services.impl;

import com.mjamsek.rest.services.Localizator;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Locale service for translating property bundles
 *
 * @author Miha Jamsek
 * @since 2.0.0
 */
public class LocalizatorImpl implements Localizator {
    
    private static final Logger LOG = LogManager.getLogManager().getLogger(LocalizatorImpl.class.getSimpleName());
    
    private static final String TRANSLATION_DIR = "i18n/translations";
    private static final Locale LOCALE_EN = new Locale("en", "US");
    
    @Override
    public String getTranslation(String key, Locale locale) {
        Optional<ResourceBundle> translations = this.getTranslations(locale);
        return translations.map(resourceBundle -> {
            if (resourceBundle.containsKey(key)) {
                return resourceBundle.getString(key);
            }
            return key;
        }).orElse(key);
    }
    
    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        Optional<ResourceBundle> translations = this.getTranslations(locale);
        return translations.map(resourceBundle -> {
            if (resourceBundle.containsKey(key)) {
                String message = resourceBundle.getString(key);
                return MessageFormat.format(message, params);
            }
            return key;
        }).orElse(key);
    }
    
    private Optional<ResourceBundle> getTranslations(Locale locale) {
        ResourceBundle.Control localeControl = ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_PROPERTIES);
        try {
            return Optional.of(ResourceBundle.getBundle(TRANSLATION_DIR, locale, localeControl));
        } catch (MissingResourceException e) {
            try {
                return Optional.of(ResourceBundle.getBundle(TRANSLATION_DIR, LOCALE_EN, localeControl));
            } catch (MissingResourceException e2) {
                LOG.log(
                    Level.WARNING,
                    "Cannot load translation bundle for language '{0}' or for fallback language 'en'!",
                    locale.toLanguageTag()
                );
                return Optional.empty();
            }
        }
    }
}
