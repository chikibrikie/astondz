package lesson_4.GeometryCalculator;

public class Triangle implements Shape {
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

    public boolean isEquilateral() {
        return Math.abs(sideA - sideB) < 0.0001 &&
                Math.abs(sideB - sideC) < 0.0001;
    }

    public boolean isIsosceles() {
        return Math.abs(sideA - sideB) < 0.0001 ||
                Math.abs(sideA - sideC) < 0.0001 ||
                Math.abs(sideB - sideC) < 0.0001;
    }
}
