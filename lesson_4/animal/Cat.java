package lesson_4.animal;

public class Cat extends Animal {
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
