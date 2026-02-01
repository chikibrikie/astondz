package com.lesson7.junit5;

import com.lesson7.NumberComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {

    @Test
    void testGreaterThan() {
        assertEquals("10 is greater than 5", NumberComparator.compare(10, 5));
    }

    @Test
    void testLessThan() {
        assertEquals("5 is less than 10", NumberComparator.compare(5, 10));
    }

    @Test
    void testEqual() {
        assertEquals("10 is equal to 10", NumberComparator.compare(10, 10));
    }
}