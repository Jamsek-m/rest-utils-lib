package com.mjamsek.rest.services;

import java.util.Locale;

public interface LocaleService {
    
    String getTranslation(String key, Locale locale);
    
    String getTranslation(String key, Locale locale, Object... params);
    
}
