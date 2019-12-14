package com.mjamsek.rest.services;

import com.mjamsek.rest.services.impl.LocaleServiceImpl;

import java.util.Locale;

public interface LocaleService {
    
    default LocaleService getInstance() {
        return new LocaleServiceImpl();
    }
    
    String getTranslation(String key, Locale locale);
    
    String getTranslation(String key, Locale locale, Object... params);
    
}
