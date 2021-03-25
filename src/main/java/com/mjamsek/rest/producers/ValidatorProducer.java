package com.mjamsek.rest.producers;

import com.mjamsek.rest.factories.ValidatorFactory;
import com.mjamsek.rest.services.Validator;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

public class ValidatorProducer {
    
    @Produces
    @Dependent
    public Validator createLocalizator() {
        return ValidatorFactory.getNewInstance();
    }
    
}
