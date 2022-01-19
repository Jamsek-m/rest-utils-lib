package com.mjamsek.rest.factories;

import com.mjamsek.rest.services.Validator;
import com.mjamsek.rest.services.impl.ValidatorImpl;

/**
 * Factory for producing {@link Validator}
 *
 * @author Miha Jamsek
 * @since 2.0.0
 */
public class ValidatorFactory {
    
    private ValidatorFactory() {
    
    }
    
    public static Validator getNewInstance() {
        return new ValidatorImpl();
    }
}
