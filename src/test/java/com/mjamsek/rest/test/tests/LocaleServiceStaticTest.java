package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.factories.LocaleServiceFactory;
import com.mjamsek.rest.services.LocaleService;
import com.mjamsek.rest.services.impl.LocaleServiceImpl;
import com.mjamsek.rest.utils.UrlUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class LocaleServiceStaticTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(LocaleService.class)
            .addAsResource("i18n/translations.properties")
            .addAsResource("i18n/translations_en_US.properties")
            .addAsResource("i18n/translations_sl_SI.properties")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    private static final Locale LOCALE_EN = new Locale("en", "US");
    private static final Locale LOCALE_SL = new Locale("sl", "SI");
    private static final Locale LOCALE_DE = new Locale("de", "DE");
    
    private LocaleService localeService;
    
    @Before
    public void init() {
        this.localeService = LocaleServiceFactory.getInstance();
    }
    
    @Test
    public void testTranslations() {
        
        assertEquals("English value", localeService.getTranslation("property.translated", LOCALE_EN));
        assertEquals("Slovenska vrednost", localeService.getTranslation("property.translated", LOCALE_SL));
        // TODO: verify
        assertEquals("Slovenska vrednost", localeService.getTranslation("property.translated", LOCALE_DE));
        
        assertEquals("Default value", localeService.getTranslation("property.default", LOCALE_EN));
        assertEquals("Default value", localeService.getTranslation("property.default", LOCALE_SL));
        assertEquals("Default value", localeService.getTranslation("property.default", LOCALE_DE));
        
    }
    
    @Test
    public void testParams() {
        
        assertEquals("Replace value 123 with '456'", localeService.getTranslation("property.params", LOCALE_EN, 123, 456));
        
    }
    
}
