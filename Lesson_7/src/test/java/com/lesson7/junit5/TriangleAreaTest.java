package com.lesson7.junit5;

import com.lesson7.TriangleArea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    @Test
    void testAreaWithPositiveNumbers() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4));
    }

    @Test
    void testAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateArea(0, 5);
        });
    }
}