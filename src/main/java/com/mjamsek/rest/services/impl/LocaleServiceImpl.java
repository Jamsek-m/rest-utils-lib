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
            String message = key;
            if (resourceBundle.containsKey(key)) {
                message = resourceBundle.getString(key);
            }
            return MessageFormat.format(message, params);
        }).orElse(key);
    }
    
    private Optional<ResourceBundle> getTranslations(Locale locale) {
        try {
            return Optional.of(ResourceBundle.getBundle(TRANSLATION_DIR, locale));
        } catch (MissingResourceException e) {
            try {
                return Optional.of(ResourceBundle.getBundle(TRANSLATION_DIR, Locale.ENGLISH));
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
