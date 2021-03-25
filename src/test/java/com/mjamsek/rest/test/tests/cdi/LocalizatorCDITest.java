package com.mjamsek.rest.test.tests.cdi;

import com.mjamsek.rest.services.Localizator;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Verifies CDI creating valid {@link Localizator} instance
 * @author Miha Jamsek
 * @since 2.0.0
 */
@RunWith(Arquillian.class)
public class LocalizatorCDITest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(Localizator.class)
            .addAsResource("i18n/translations.properties")
            .addAsResource("i18n/translations_en_US.properties")
            .addAsResource("i18n/translations_sl_SI.properties")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    private Localizator localizator;
    
    private static final Locale LOCALE_EN = new Locale("en", "US");
    private static final Locale LOCALE_DE = new Locale("de", "DE");
    
    @Test
    public void translations() {
        assertEquals("English value", localizator.getTranslation("property.translated", LOCALE_EN));
        assertEquals("Default value", localizator.getTranslation("property.translated", LOCALE_DE));
        assertEquals("Default value", localizator.getTranslation("property.default", LOCALE_EN));
    }
    
    @Test
    public void paramsReplacing() {
        assertEquals("Replace value 123 with '456'", localizator.getTranslation("property.params", LOCALE_EN, 123, 456));
    }
    
}
