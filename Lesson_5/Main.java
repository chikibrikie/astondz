package Lesson_5;

import Lesson_5.exceptions.MyArrayDataException;
import Lesson_5.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ОБРАБОТКА МАССИВОВ С ИСКЛЮЧЕНИЯМИ ===\n");

        // Тест 1: Корректный массив 4x4
        System.out.println("Тест 1: Корректный массив 4x4");
        String[][] correctArray = {
                { "1", "2", "3", "4" },
                { "5", "6", "7", "8" },
                { "9", "10", "11", "12" },
                { "13", "14", "15", "16" }
        };

        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Успешно! Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
            System.out.println("Строка: " + e.getRow() + ", Столбец: " + e.getCol());
        }
        System.out.println();

        // Тест 2: Массив с некорректными данными
        System.out.println("Тест 2: Массив с некорректными данными");
        String[][] invalidDataArray = {
                { "1", "2", "3", "4" },
                { "5", "6", "7", "8" },
                { "9", "десять", "11", "12" },
                { "13", "14", "15", "16" }
        };

        try {
            int result = ArrayProcessor.processArray(invalidDataArray);
            System.out.println("Успешно! Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
            System.out.println("Строка: " + e.getRow() + ", Столбец: " + e.getCol());
        }
        System.out.println();

        // Тест 3: Массив неправильного размера (3x3)
        System.out.println("Тест 3: Массив неправильного размера (3x3)");
        String[][] wrongSizeArray = {
                { "1", "2", "3" },
                { "4", "5", "6" },
                { "7", "8", "9" }
        };

        try {
            int result = ArrayProcessor.processArray(wrongSizeArray);
            System.out.println("Успешно! Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
            System.out.println("Строка: " + e.getRow() + ", Столбец: " + e.getCol());
        }

        System.out.println("\n" + "=".repeat(50) + "\n");
        System.out.println("=== ГЕНЕРАЦИЯ И ОБРАБОТКА ArrayIndexOutOfBoundsException ===\n");

        // Пример 1: Одномерный массив
        System.out.println("Пример 1: Одномерный массив");
        int[] numbers = { 10, 20, 30, 40, 50 };
        try {
            System.out.println("Массив: {10, 20, 30, 40, 50}");
            System.out.println("Попытка получить элемент с индексом 7...");

            int element = numbers[7];
            System.out.println("Элемент numbers[7] = " + element);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getClass().getName());
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Допустимые индексы: от 0 до " + (numbers.length - 1));

            System.out.println("\nТрассировка стека (stack trace):");
            e.printStackTrace();
        } finally {
            System.out.println("Блок finally выполнен. Очистка ресурсов...");
        }
        System.out.println();

        // Пример 2: Двумерный массив - выход по строкам
        System.out.println("Пример 2: Двумерный массив - выход по строкам");
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        try {
            System.out.println("Массив 3x3:");
            for (int[] row : matrix) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("Попытка получить элемент matrix[3][0]...");
            int value = matrix[3][0];
            System.out.println("matrix[3][0] = " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: обращение к несуществующей строке!");
            System.out.println("Массив имеет " + matrix.length + " строк(и)");
        }
        System.out.println();

        // Пример 3: Двумерный массив - выход по столбцам
        System.out.println("Пример 3: Двумерный массив - выход по столбцам");
        try {
            System.out.println("Попытка получить элемент matrix[1][5]...");
            int value = matrix[1][5];
            System.out.println("matrix[1][5] = " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: обращение к несуществующему столбцу!");
            System.out.println("Строка 1 имеет " + matrix[1].length + " столбца(ов)");
        }
    }
}