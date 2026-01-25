package lesson_4.animal;

public abstract class Animal {
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
