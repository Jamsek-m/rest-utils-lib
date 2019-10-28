package com.mjamsek.rest.services;

import java.util.Locale;

public interface LocaleService {
    
    default Locale getLocale() {
        return Locale.ENGLISH;
    }
    
    String getTranslation(String key);
    
    String getTranslation(String key, Object... params);
    
}
