package lesson_4.GeometryCalculator;

public class GeometryCalculator {
    public static void main(String[] args) {
        System.out.println("=== ПРОГРАММА РАСЧЕТА ГЕОМЕТРИЧЕСКИХ ФИГУР ===\n");

        try {
            Circle circle = new Circle(5.0, Color.RED, Color.BLACK);
            Rectangle rectangle = new Rectangle(4.0, 6.0, Color.GREEN, Color.BLUE);
            Triangle triangle = new Triangle(3.0, 4.0, 5.0, Color.YELLOW, Color.PURPLE);
            Triangle equilateralTriangle = new Triangle(5.0, 5.0, 5.0, Color.PINK, Color.ORANGE);

            System.out.println("1. Информация о круге:");
            circle.printInfo();

            System.out.println("2. Информация о прямоугольнике:");
            rectangle.printInfo();

            System.out.println("3. Информация о треугольнике (3-4-5):");
            triangle.printInfo();
            System.out.println("   Дополнительно: треугольник " +
                    (triangle.isRightTriangle() ? "является" : "не является") + " прямоугольным.");

            System.out.println("\n4. Информация о равностороннем треугольнике:");
            equilateralTriangle.printInfo();

            System.out.println("=== Демонстрация полиморфизма ===\n");

            Shape[] shapes = { circle, rectangle, triangle, equilateralTriangle };
            double totalArea = 0;
            double totalPerimeter = 0;

            System.out.println("Сводная информация по всем фигурам:");
            System.out.println("------------------------------------");

            for (int i = 0; i < shapes.length; i++) {
                Shape shape = shapes[i];
                System.out.printf("%d. %s:\n", i + 1, shape.getShapeName());
                System.out.printf("   Площадь: %.2f, Периметр: %.2f\n",
                        shape.calculateArea(), shape.calculatePerimeter());
                System.out.printf("   Цвета: заливка - %s, граница - %s\n",
                        shape.getFillColor().getRussianName(),
                        shape.getBorderColor().getRussianName());

                totalArea += shape.calculateArea();
                totalPerimeter += shape.calculatePerimeter();
            }

            System.out.println("\n------------------------------------");
            System.out.printf("ИТОГО по всем фигурам:\n");
            System.out.printf("Общая площадь: %.2f\n", totalArea);
            System.out.printf("Общий периметр: %.2f\n", totalPerimeter);

            System.out.println("\n=== Демонстрация дефолтных методов ===\n");

            Shape unknownShape = new Shape() {
                @Override
                public double calculateArea() {
                    return 100.0;
                }

                @Override
                public Color getFillColor() {
                    return Color.GRAY;
                }

                @Override
                public Color getBorderColor() {
                    return Color.BLACK;
                }
            };

            System.out.println("Неизвестная фигура:");
            System.out.println("Название: " + unknownShape.getShapeName());
            System.out.println("Площадь: " + unknownShape.calculateArea());
            System.out.println("Периметр: " + unknownShape.calculatePerimeter());
            System.out.println("Цвет заливки: " + unknownShape.getFillColor().getRussianName());

            System.out.println("\n=== Демонстрация обработки ошибок ===\n");

            try {
                System.out.println("Попытка создать круг с радиусом -5.0:");
                Circle invalidCircle = new Circle(-5.0, Color.RED, Color.BLACK);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            try {
                System.out.println("\nПопытка создать треугольник со сторонами 1, 2, 10:");
                Triangle invalidTriangle = new Triangle(1.0, 2.0, 10.0, Color.RED, Color.BLACK);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }
}