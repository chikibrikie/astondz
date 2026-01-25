package lesson_4.animal;

public class Dog extends Animal {
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
