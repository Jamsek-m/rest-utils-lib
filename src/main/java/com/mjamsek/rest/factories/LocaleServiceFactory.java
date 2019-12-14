package com.mjamsek.rest.factories;

import com.mjamsek.rest.services.LocaleService;
import com.mjamsek.rest.services.impl.LocaleServiceImpl;

public class LocaleServiceFactory {
    
    public static LocaleService getInstance() {
        return new LocaleServiceImpl();
    }
    
}
