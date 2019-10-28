package com.mjamsek.rest.services.impl;

import com.mjamsek.rest.services.LocaleService;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@RequestScoped
public class LocaleServiceImpl implements LocaleService {
    
    private static final String TRANSLATION_DIR = "i18n/translations";
    
    @Context
    private HttpServletRequest request;
    
    @Override
    public Locale getLocale() {
        return this.request.getLocale();
    }
    
    @Override
    public String getTranslation(String key) {
        ResourceBundle translations = ResourceBundle.getBundle(TRANSLATION_DIR, this.getLocale());
        return translations.getString(key);
    }
    
    @Override
    public String getTranslation(String key, Object... params) {
        ResourceBundle translations = ResourceBundle.getBundle(TRANSLATION_DIR, this.getLocale());
        String message = translations.getString(key);
        return MessageFormat.format(message, params);
    }
}
