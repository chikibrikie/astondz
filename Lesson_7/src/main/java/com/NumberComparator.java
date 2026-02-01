package Lesson_7.src.main.java.com;

public class NumberComparator {
    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static boolean isGreater(int a, int b) {
        return a > b;
    }

    public static boolean isLess(int a, int b) {
        return a < b;
    }

    public static boolean areEqual(int a, int b) {
        return a == b;
    }

    public static int findMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int findMin(int a, int b) {
        return Math.min(a, b);
    }
}
