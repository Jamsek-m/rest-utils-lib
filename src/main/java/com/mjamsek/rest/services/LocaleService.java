package com.mjamsek.rest.services;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public interface LocaleService {
    
    default Locale getLocale() {
        return Locale.ENGLISH;
    }
    
    String getTranslation(String key);
    
    String getTranslation(String key, Object... params);
    
    String getTranslation(String key, HttpServletRequest request);
    
    String getTranslation(String key, HttpServletRequest request, Object... params);
    
}
