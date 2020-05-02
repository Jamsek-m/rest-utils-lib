package com.mjamsek.rest.test;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;

public class RestUtilsArquillianExtension implements LoadableExtension {
    
    @Override
    public void register(ExtensionBuilder extensionBuilder) {
        extensionBuilder.service(AuxiliaryArchiveAppender.class, RestUtilsLibraryAppender.class);
    }
}
