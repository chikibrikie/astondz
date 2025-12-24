public class Task9 {
    public static boolean leapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println(leapYear(2000));
        System.out.println(leapYear(1997));
    }
}
