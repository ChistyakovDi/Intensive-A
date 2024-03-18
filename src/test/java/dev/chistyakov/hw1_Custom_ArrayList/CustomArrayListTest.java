package dev.chistyakov.hw1_Custom_ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {
    private CustomArrayList<Integer> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testAddAndGet() {
        customArrayList.add(0, 1);
        customArrayList.add(1, 2);
        customArrayList.add(2, 3);
        assertEquals(1, customArrayList.get(0));
        assertEquals(2, customArrayList.get(1));
        assertEquals(3, customArrayList.get(2));
    }

    @Test
    void testAddAll() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        customArrayList.addAll(list);
        assertEquals(3, customArrayList.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), customArrayList.get(i));
        }
    }

    @Test
    void testClear() {
        customArrayList.addAll(Arrays.asList(1, 2, 3));
        customArrayList.clear();
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    void testIsEmptyWhenEmpty() {
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    void testIsEmptyWhenNotEmpty() {
        customArrayList.addAll(Arrays.asList(1, 2, 3));
        assertFalse(customArrayList.isEmpty());
    }

    @Test
    void testRemove() {
        customArrayList.addAll(Arrays.asList(1, 2, 3));
        customArrayList.remove(1);
        assertEquals(2, customArrayList.size());
        assertEquals(1, customArrayList.get(0));
        assertEquals(3, customArrayList.get(1));
    }

    @Test
    void testRemoveObject() {
        customArrayList.addAll(Arrays.asList(1, 2, 3));
        assertTrue(customArrayList.remove(Integer.valueOf(2)));
        assertEquals(2, customArrayList.size());
        assertEquals(1, customArrayList.get(0));
        assertEquals(3, customArrayList.get(1));
    }

    @Test
    void testSort() {
        customArrayList.addAll(Arrays.asList(3, 2, 1));
        customArrayList.sort(Integer::compareTo);
        assertEquals(1, customArrayList.get(0));
        assertEquals(2, customArrayList.get(1));
        assertEquals(3, customArrayList.get(2));
    }
}