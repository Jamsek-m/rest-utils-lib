package com.mjamsek.rest.utils;

public class UrlUtil {
    
    public static String removeTrailingSlash(String s) {
        if (s.endsWith("/")) {
            return s.substring(0, s.length() - 1);
        }
        return s;
    }
    
    public static String removeLeadingSlash(String s) {
        if (s.startsWith("/")) {
            return s.substring(1);
        }
        return s;
    }
    
    public static String removeLastPath(String s) {
        if (!s.endsWith("/")) {
            int replaceIndex = s.lastIndexOf('/');
            return s.substring(0, replaceIndex + 1);
        }
        return s;
    }
    
}
