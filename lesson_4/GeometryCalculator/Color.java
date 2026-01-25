package lesson_4.GeometryCalculator;

public enum Color {
    RED("Красный"),
    GREEN("Зеленый"),
    BLUE("Синий"),
    YELLOW("Желтый"),
    BLACK("Черный"),
    WHITE("Белый"),
    PURPLE("Фиолетовый"),
    ORANGE("Оранжевый"),
    PINK("Розовый"),
    GRAY("Серый");

    private final String russianName;

    Color(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }
}
