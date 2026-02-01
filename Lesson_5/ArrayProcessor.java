
import Lesson_5.exceptions.MyArrayDataException;
import Lesson_5.exceptions.MyArraySizeException;

public class ArrayProcessor {

    public static int processArray(String[][] array) throws MyArrayDataException, MyArraySizeException {

        // --- ПРОВЕРКА РАЗМЕРА МАССИВА ---

        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Массив должен иметь 4 строки, получено: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4) {
                throw new MyArraySizeException(
                        String.format("Строка %d должна иметь 4 столбца, получено: %d", i, array[i].length));
            }
        }

        // --- ВЫЧИСЛЕНИЕ СУММЫ ---

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}