package com.lesson7.testng;

import com.lesson7.TriangleArea;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {

    @Test
    public void testAreaWithValidInput() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroBase() {
        TriangleArea.calculateArea(0, 4);
    }
}