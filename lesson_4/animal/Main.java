package lesson_4.animal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Начало программы ===");

        Dog dog1 = new Dog("Найда");
        Dog dog2 = new Dog("Лапа");
        Cat cat1 = new Cat("Фара");
        Cat cat2 = new Cat("Боня");

        System.out.println("----------Способности собак-------------");

        dog1.run(133);
        dog2.run(777);
        dog1.swim(15);
        dog2.swim(5);

        System.out.println("----------Способности кошек------------------");

        cat1.run(77);
        cat1.run(777);
        cat1.swim(1);
        cat2.swim(2);

        System.out.println("------------Миска с едой-----------------");

        Bowl bowl = new Bowl(3);

        List<Cat> cats = new ArrayList<>();

        cats.add(new Cat("Элвис"));
        cats.add(new Cat("Гриня"));
        cats.add(new Cat("Вася"));
        cats.add(new Cat("Мурка"));

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            String status = cat.isFull() ? "сыт(а)" : "голоден(на)";
            System.out.println(cat.getName() + ": " + status);
        }

        System.out.println("В миске осталось: " + bowl.getFoodAmount() + " еды.");

        System.out.println("------Добавляем еду в миску--------");
        bowl.addFood(2);

        System.out.println("----------пробуем покормить голодных котов---------------------");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl);
            }
        }

        System.out.println("--- Итоговое состояние ---");

        for (Cat cat : cats) {
            String status = cat.isFull() ? "сыт(а)" : "голоден(на)";
            System.out.println(cat.getName() + ": " + status);
        }

        bowl.printFoodStatus();

        System.out.println("----------Общее количество животных-------------");

        System.out.println("Всего животных: " + Animal.getTotalCount() + ".");
    }

}
