package Lesson_7.src.main.java.com.example;

public class FactorialCalculator {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
