public class Task5 {
    public static boolean sumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void main(String[] args) {
        System.out.println(sumInRange(5, 5));
        System.out.println(sumInRange(11, 11));
    }
}
