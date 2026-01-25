package lesson_4.animal;

public class Bowl {
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
