package lesson_4;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    private static int totalCount = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
        totalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static void resetTotalCount() {
        totalCount = 0;
        System.out.println("Счетчик сброшен");
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        this.foodAmount = Math.max(0, initialFood);
        System.out.println("Создана миска с " + this.foodAmount + " единицами еды.");
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public boolean decreseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            System.out.println("Из миски убрано " + amount + " еда. Осталось: " + foodAmount);
            return true;
        } else {
            System.out.println("Недостаточно еды в миске! Запрошено: " + amount + ", доступно" + foodAmount);
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount + " еды.");
        } else {
            System.out.println("Ошибка: нельзя добавить отрицательное количество еды (" + amount + ")!");
        }
    }

    public void printFoodStatus() {
        System.out.println("Текущее состояние миски: " + foodAmount + " единиц еды.");
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
        System.out.println("Создана собака: " + name + ".");
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал(а) " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance
                    + " м. Максимальная дистанция бега для собак: " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплыл(а) " + distance + " м.");
        } else {
            System.out.println(getName() + " собака не проплыть " + distance + " м. Максимальная дистанция заплыва "
                    + MAX_SWIM_DISTANCE + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }

    public static void resetDogCount() {
        dogCount = 0;
        System.out.println("Счетчик собак сброшен.");
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
        System.out.println("Создан кот: " + name + ".");
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал(а) " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + "м. Максимум для кошачих: "
                    + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать. Коты боятся воды.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= 1) {
            if (bowl.decreseFood(1)) {
                isFull = true;
                System.out.println(getName() + " поел(а) и теперь сыт(а).");
            }
        } else {
            System.out.println(getName() + " не поел(а). В миске нет еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }

    public static void resetCatCount() {
        catCount = 0;
        System.out.println("Счётчик котов сброшен.");
    }
}

class Main {
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

        System.out.println("=== Итоговое состояние ===");

        for (Cat cat : cats) {
            String status = cat.isFull() ? "сыт(а)" : "голоден(на)";
            System.out.println(cat.getName() + ": " + status);
        }

        bowl.printFoodStatus();

        System.out.println("----------Общее количество животных-------------");

        System.out.println("Всего животных: " + Animal.getTotalCount() + ".");
    }
}
