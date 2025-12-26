public class Task14 {
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;

    }

    public static void main(String[] args) {

        int[] array1 = createArray(4, 6);

        printArray(array1);
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
