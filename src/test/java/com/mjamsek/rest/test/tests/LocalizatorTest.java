package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.factories.LocalizatorFactory;
import com.mjamsek.rest.services.Localizator;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class LocalizatorTest {
    
    private static final Locale LOCALE_EN = new Locale("en", "US");
    private static final Locale LOCALE_SL = new Locale("sl", "SI");
    private static final Locale LOCALE_DE = new Locale("de", "DE");
    
    private Localizator localizator;
    
    @Before
    public void init() {
        this.localizator = LocalizatorFactory.getNewInstance();
    }
    
    @Test
    public void testTranslations() {
        
        assertEquals("English value", localizator.getTranslation("property.translated", LOCALE_EN));
        assertEquals("Slovenska vrednost", localizator.getTranslation("property.translated", LOCALE_SL));
        assertEquals("Default value", localizator.getTranslation("property.translated", LOCALE_DE));
        
        assertEquals("Default value", localizator.getTranslation("property.default", LOCALE_EN));
        assertEquals("Default value", localizator.getTranslation("property.default", LOCALE_SL));
        assertEquals("Default value", localizator.getTranslation("property.default", LOCALE_DE));
        
    }
    
    @Test
    public void testParams() {
        
        assertEquals("Replace value 123 with '456'", localizator.getTranslation("property.params", LOCALE_EN, 123, 456));
        
    }
    
}
