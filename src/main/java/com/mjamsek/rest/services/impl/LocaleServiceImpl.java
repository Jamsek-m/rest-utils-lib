package com.mjamsek.rest.services.impl;

import com.mjamsek.rest.services.LocaleService;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RequestScoped
public class LocaleServiceImpl implements LocaleService {
    
    private static final Logger LOG = LogManager.getLogManager().getLogger(LocaleServiceImpl.class.getSimpleName());
    
    private static final String TRANSLATION_DIR = "i18n/translations";
    
    @Context
    private HttpServletRequest request;
    
    @Override
    public Locale getLocale() {
        return this.request.getLocale();
    }
    
    @Override
    public String getTranslation(String key) {
        Optional<ResourceBundle> translations = this.getTranslations();
        return translations.map(resourceBundle -> resourceBundle.getString(key)).orElse(key);
    }
    
    @Override
    public String getTranslation(String key, Object... params) {
        Optional<ResourceBundle> translations = this.getTranslations();
        return translations.map(resourceBundle -> {
            String message = resourceBundle.getString(key);
            return MessageFormat.format(message, params);
        }).orElse(key);
    }
    
    @Override
    public String getTranslation(String key, HttpServletRequest request) {
        Optional<ResourceBundle> translations = this.getTranslations(request.getLocale());
        return translations.map(resourceBundle -> resourceBundle.getString(key)).orElse(key);
    }
    
    @Override
    public String getTranslation(String key, HttpServletRequest request, Object... params) {
        Optional<ResourceBundle> translations = this.getTranslations(request.getLocale());
        return translations.map(resourceBundle -> {
            String message = resourceBundle.getString(key);
            return MessageFormat.format(message, params);
        }).orElse(key);
    }
    
    private Optional<ResourceBundle> getTranslations() {
        return this.getTranslations(this.getLocale());
    }
    
    private Optional<ResourceBundle> getTranslations(Locale locale) {
        try {
            return Optional.of(ResourceBundle.getBundle(TRANSLATION_DIR, locale));
        } catch (MissingResourceException e) {
            try {
                return Optional.of(ResourceBundle.getBundle(TRANSLATION_DIR, new Locale("en")));
            } catch (MissingResourceException e2) {
                LOG.warning(String.format(
                    "Cannot load translation bundle for language '%s' or for fallback language 'en'!",
                    locale.toLanguageTag()
                ));
                return Optional.empty();
            }
        }
    }
    
}
