package lesson_4.GeometryCalculator;

public interface Shape {
    double calculateArea();

    default double calculatePerimeter() {
        return 0.0;
    }

    Color getFillColor();

    Color getBorderColor();

    default String getShapeName() {
        return "Геометрическая фигура";
    }

    default void printInfo() {
        System.out.println("=== Информация о фигуре ===");
        System.out.println("Название: " + getShapeName());
        System.out.printf("Площадь: %.2f\n", calculateArea());
        System.out.printf("Периметр: %.2f\n", calculatePerimeter());
        System.out.println("Цвет заливки: " + getFillColor().getRussianName());
        System.out.println("Цвет границы: " + getBorderColor().getRussianName());
        System.out.println("==========================\n");
    }
}
