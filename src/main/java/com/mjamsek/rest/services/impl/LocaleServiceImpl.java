package com.mjamsek.rest.services.impl;

import com.mjamsek.rest.services.LocaleService;

import javax.enterprise.context.RequestScoped;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RequestScoped
public class LocaleServiceImpl implements LocaleService {
    
    private static final Logger LOG = LogManager.getLogManager().getLogger(LocaleServiceImpl.class.getSimpleName());
    
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
