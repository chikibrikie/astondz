package com.lesson7.junit5;

import com.lesson7.FactorialCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    void testFactorialOfNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });
    }
}