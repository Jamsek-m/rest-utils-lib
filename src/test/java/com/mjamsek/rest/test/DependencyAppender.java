package com.mjamsek.rest.test;

import com.kumuluz.ee.testing.arquillian.spi.MavenDependencyAppender;
import org.jboss.shrinkwrap.resolver.api.maven.ConfigurableMavenResolverSystem;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.jboss.shrinkwrap.resolver.api.maven.repository.MavenRemoteRepositories;
import org.jboss.shrinkwrap.resolver.api.maven.repository.MavenRemoteRepository;
import org.jboss.shrinkwrap.resolver.api.maven.repository.MavenUpdatePolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DependencyAppender implements MavenDependencyAppender {
    
    private static final ResourceBundle versionsBundle = ResourceBundle.getBundle("META-INF/kumuluzee/versions");
    
    @Override
    public ConfigurableMavenResolverSystem configureResolver(ConfigurableMavenResolverSystem resolver) {
        
        MavenRemoteRepository mjamsekRepository = MavenRemoteRepositories.createRemoteRepository("mjamsek-public", "https://nexus.mjamsek.com/repository/maven-public", "default");
        mjamsekRepository.setUpdatePolicy(MavenUpdatePolicy.UPDATE_POLICY_ALWAYS);
        
        resolver.loadPomFromFile("pom.xml").importDependencies(ScopeType.RUNTIME);
        
        // resolver.withRemoteRepo(mjamsekRepository);
        
        return resolver;
    }
    
    @Override
    public List<String> addLibraries() {
        List<String> libs = new ArrayList<>();
        
        libs.add("com.kumuluz.ee:kumuluzee-jax-rs-jersey:");
        
        libs.add("com.fasterxml.jackson.core:jackson-databind:" + versionsBundle.getString("jackson-version"));
        
        return libs;
    }
}
