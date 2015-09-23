package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayIntervalMapTest {

    @Test
    public void test() throws Exception {
        ArrayIntervalMap<Integer, String> map = new ArrayIntervalMap<>();
        map.put(13, "13");
        map.put(11, "11");

        // test continuously add
        map.put(1, "1");
        map.put(3, "3");
        map.put(5, "5");
        map.put(7, "7");
        map.put(9, "9");

        // test inserting
        map.put(0, "0");
        map.put(6, "6");

        assertEquals(9, map.size());

        // exact match
        assertEquals("0", map.get(0));
        assertEquals("9", map.get(9));
        assertEquals("13", map.get(13));

        // < match
        assertEquals("1", map.get(2));
        assertEquals("13", map.get(14));
        assertEquals("11", map.get(12));
        assertEquals("13", map.get(15));

        // negative match
        assertNull(map.get(-1));

        // modify
        map.put(6, "6p");
        map.put(11, "11p");
        map.put(15, "15");

        assertEquals(10, map.size());

        assertEquals("7", map.get(7));
        assertEquals("6p", map.get(6));
        assertEquals("15", map.get(15));
        assertEquals("11p", map.get(11));
        assertEquals("15", map.get(16));
        assertEquals("11p", map.get(12));
    }
}