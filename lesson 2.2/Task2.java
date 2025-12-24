public class Task2 {
    public static void checkSumSign() {
        int a = 15;
        int b = -10; // для проверки отрицательного варианта -20
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void main(String[] args) {
        checkSumSign();
    }
}
