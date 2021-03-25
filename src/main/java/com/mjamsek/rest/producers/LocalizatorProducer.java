package com.mjamsek.rest.producers;

import com.mjamsek.rest.factories.LocalizatorFactory;
import com.mjamsek.rest.services.Localizator;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

public class LocalizatorProducer {
    
    @Produces
    @RequestScoped
    public Localizator createLocalizator() {
        return LocalizatorFactory.getNewInstance();
    }
    
}
