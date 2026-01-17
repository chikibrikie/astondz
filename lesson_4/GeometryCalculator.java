package lesson_4;

import java.lang.Math;

enum Color {
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

interface Shape {
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

class Circle implements Shape {
    private final double radius;
    private final Color fillColor;
    private final Color borderColor;
    private static final double PI = Math.PI;

    public Circle(double radius, Color fillColor, Color borderColor) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным: " + radius);
        }
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public String getShapeName() {
        return "Круг";
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle implements Shape {
    private final double width;
    private final double height;
    private final Color fillColor;
    private final Color borderColor;

    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Ширина и высота должны быть положительными: width=" + width + ", height=" + height);
        }
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public String getShapeName() {
        return "Прямоугольник";
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Triangle implements Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final Color fillColor;
    private final Color borderColor;

    public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException(
                    "Все стороны должны быть положительными: a=" + sideA + ", b=" + sideB + ", c=" + sideC);
        }

        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException(
                    "Стороны не образуют треугольник: a=" + sideA + ", b=" + sideB + ", c=" + sideC);
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    @Override
    public String getShapeName() {
        return "Треугольник";
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public boolean isRightTriangle() {
        double maxSide = Math.max(sideA, Math.max(sideB, sideC));
        double tolerance = 0.0001;

        if (Math.abs(maxSide - sideA) < tolerance) {
            return Math.abs(sideA * sideA - (sideB * sideB + sideC * sideC)) < tolerance;
        } else if (Math.abs(maxSide - sideB) < tolerance) {
            return Math.abs(sideB * sideB - (sideA * sideA + sideC * sideC)) < tolerance;
        } else {
            return Math.abs(sideC * sideC - (sideA * sideA + sideB * sideB)) < tolerance;
        }
    }
}

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