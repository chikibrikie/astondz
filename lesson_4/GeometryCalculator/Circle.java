package lesson_4.GeometryCalculator;

public class Circle implements Shape {
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

    public double getDiameter() {
        return 2 * radius;
    }
}
