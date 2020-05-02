package com.mjamsek.rest.test;

import org.jboss.arquillian.container.test.spi.client.deployment.CachedAuxilliaryArchiveAppender;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public class RestUtilsLibraryAppender extends CachedAuxilliaryArchiveAppender {
    
    @Override
    protected Archive<?> buildArchive() {
        return ShrinkWrap.create(JavaArchive.class, "rest-utils-0.0.0.jar")
            .addPackages(true, "com.mjamsek.rest")
            .addAsResource("META-INF/beans.xml");
    }
}
