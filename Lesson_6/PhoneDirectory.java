package Lesson_6;

import java.util.*;

public class PhoneDirectory {
    private final Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {

        if (!directory.containsKey(lastName)) {
            directory.put(lastName, new ArrayList<>());
        }
        directory.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, new ArrayList<>());
    }
}

class PhoneDirectoryMain {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Иванов", "123-45-67");
        directory.add("Петров", "987-65-43");
        directory.add("Иванов", "555-55-55"); // Второй номер для Иванова
        directory.add("Сидоров", "111-22-33");
        directory.add("Иванов", "999-88-77"); // Третий номер для Иванова

        // Получаем номера по фамилии
        System.out.println("Номера Иванова: " + directory.get("Иванов"));
        System.out.println("Номера Петрова: " + directory.get("Петров"));
        System.out.println("Номера Сидорова: " + directory.get("Сидоров"));
        System.out.println("Номера Кузнецова: " + directory.get("Кузнецов")); // Несуществующая фамилия

        // Демонстрация работы с однофамильцами
        directory.add("Петров", "444-44-44"); // Еще один номер для Петрова
        System.out.println("\nВсе номера Петрова после добавления: " + directory.get("Петров"));
    }
}
