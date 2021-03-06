package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.utils.UrlUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlUtilTest {
    
    @Test
    public void testLeadingSlashStriping() {
    
        assertEquals("", UrlUtil.removeLeadingSlash(""));
        assertEquals("", UrlUtil.removeLeadingSlash("/"));
        assertEquals("path", UrlUtil.removeLeadingSlash("/path"));
        assertEquals("path/test", UrlUtil.removeLeadingSlash("/path/test"));
        assertEquals("path/", UrlUtil.removeLeadingSlash("/path/"));
        assertEquals("test", UrlUtil.removeLeadingSlash("test"));
    
        // Check immutability
        String path = "/path/";
        String trimmedPath = UrlUtil.removeLeadingSlash(path);
        assertEquals("/path/", path);
        assertEquals("path/", trimmedPath);
    }
    
    @Test
    public void testTrailingSlashStriping() {
    
        assertEquals("", UrlUtil.removeTrailingSlash(""));
        assertEquals("", UrlUtil.removeTrailingSlash("/"));
        assertEquals("/path", UrlUtil.removeTrailingSlash("/path"));
        assertEquals("path", UrlUtil.removeTrailingSlash("path/"));
        assertEquals("/path/test", UrlUtil.removeTrailingSlash("/path/test"));
        assertEquals("/path", UrlUtil.removeTrailingSlash("/path/"));
        assertEquals("test", UrlUtil.removeTrailingSlash("test"));
    
        // Check immutability
        String path = "/path/";
        String trimmedPath = UrlUtil.removeTrailingSlash(path);
        assertEquals("/path/", path);
        assertEquals("/path", trimmedPath);
    }
    
    @Test
    public void testRemovingLastPath() {
    
        assertEquals("", UrlUtil.removeLastPath(""));
        assertEquals("/", UrlUtil.removeLastPath("/"));
        assertEquals("/path/to/", UrlUtil.removeLastPath("/path/to/smth"));
        assertEquals("relative/path/", UrlUtil.removeLastPath("relative/path/somewhere"));
        assertEquals("relative/path/somewhere/", UrlUtil.removeLastPath("relative/path/somewhere/"));
    
        // Check immutability
        String path = "/path/to/something";
        String trimmedPath = UrlUtil.removeLastPath(path);
        assertEquals("/path/to/something", path);
        assertEquals("/path/to/", trimmedPath);
        
    }
    
}
