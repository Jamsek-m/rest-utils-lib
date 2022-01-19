package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.utils.HandleUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class HandleUtilTest {
    
    @Test
    public void testCreateHandle() {
        assertEquals("hello-world", HandleUtil.toHandle("Hello, world!"));
        assertEquals("hello-world", HandleUtil.toHandle("hello-world"));
        assertEquals("hiha-123", HandleUtil.toHandle("HiHa   123"));
        assertEquals("test_val-123", HandleUtil.toHandle("test_val 123"));
        assertEquals("", HandleUtil.toHandle("   "));
        assertEquals("", HandleUtil.toHandle(""));
    }
    
    @Test
    public void testValidHandle() {
        assertTrue(HandleUtil.validHandle("hello-world"));
        assertTrue(HandleUtil.validHandle("hello"));
        assertTrue(HandleUtil.validHandle("hello_world-123"));
        
        assertFalse(HandleUtil.validHandle("hello!"));
        assertFalse(HandleUtil.validHandle("Hello"));
        assertFalse(HandleUtil.validHandle("Hello    all"));
        assertFalse(HandleUtil.validHandle("Hi all"));
        assertFalse(HandleUtil.validHandle("Test, all"));
        assertFalse(HandleUtil.validHandle("    "));
        assertFalse(HandleUtil.validHandle(""));
    }
    
}
