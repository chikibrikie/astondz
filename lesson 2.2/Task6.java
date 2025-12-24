public class Task6 {
    public static void cheсkNumber(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }

    public static void main(String[] args) {
        cheсkNumber(1);
        cheсkNumber(0);
        cheсkNumber(-1);
    }
}
