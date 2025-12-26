public class Task3 {
    public static void printColor() {
        int value = 101; // -1 = Красный, 101 = Зеленый.
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void main(String[] args) {
        printColor();
    }
}
