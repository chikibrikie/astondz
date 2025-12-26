public class Task7 {
    public static boolean cheсkNumber(int number) {
        return number < 0;
    }

    public static void main(String[] args) {
        System.out.println(cheсkNumber(1));
        System.out.println(cheсkNumber(0));
        System.out.println(cheсkNumber(-1));
    }
}
