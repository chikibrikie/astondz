public class Task8 {
    public static void printString(String text, int number) {
        for (int i = 0; i < number; i++)
            System.out.println(text);
    }

    public static void main(String[] args) {
        printString("Hello", 3);
    }
}