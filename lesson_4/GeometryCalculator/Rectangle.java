package lesson_4.GeometryCalculator;

public class Rectangle implements Shape {
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

    public boolean isSquare() {
        return Math.abs(width - height) < 0.0001;
    }
}
