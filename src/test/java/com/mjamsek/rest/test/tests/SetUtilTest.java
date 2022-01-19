package com.mjamsek.rest.test.tests;

import com.mjamsek.rest.utils.SetUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SetUtilTest {
    
    @Test
    public void testUnion() {
        Set<String> set1 = Set.of("one", "two");
        Set<String> set2 = Set.of("three", "four", "one");
        Set<String> setResult1 = Set.of("one", "two", "three", "four");
        Set<Integer> set3 = Set.of(1, 2);
        Set<Integer> set4 = Set.of(3, 4, 2);
        Set<Integer> setResult2 = Set.of(1, 2, 3, 4);
        
        assertEquals(setResult1, SetUtil.union(set1, set2));
        assertEquals(setResult2, SetUtil.union(set3, set4));
        assertEquals(set1, SetUtil.union(set1, new HashSet<>()));
        assertEquals(set1, SetUtil.union(new HashSet<>(), set1));
    }
    
    @Test
    public void testIntersection() {
        Set<String> set1 = Set.of("one", "two");
        Set<String> set2 = Set.of("three", "four", "one");
        Set<String> setResult1 = Set.of("one");
        Set<Integer> set3 = Set.of(1, 2);
        Set<Integer> set4 = Set.of(3, 4, 2);
        Set<Integer> setResult2 = Set.of(2);
        
        assertEquals(setResult1, SetUtil.intersection(set1, set2));
        assertEquals(setResult2, SetUtil.intersection(set3, set4));
        assertEquals(new HashSet<>(), SetUtil.intersection(set1, new HashSet<>()));
        assertEquals(new HashSet<>(), SetUtil.intersection(new HashSet<>(), set1));
    }
    
}
