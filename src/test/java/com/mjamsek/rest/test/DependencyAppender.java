package com.mjamsek.rest.test;

import com.kumuluz.ee.testing.arquillian.spi.MavenDependencyAppender;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DependencyAppender implements MavenDependencyAppender {
    
    private static final ResourceBundle versionsBundle = ResourceBundle.getBundle("META-INF/kumuluzee/versions");
    
    @Override
    public List<String> addLibraries() {
        List<String> libs = new ArrayList<>();
        
        libs.add("com.kumuluz.ee:kumuluzee-jax-rs-jersey:");
        
        libs.add("com.fasterxml.jackson.core:jackson-databind:" + versionsBundle.getString("jackson-version"));
        
        return libs;
    }
}
