package exercise;

// BEGIN
public class Circle {
    private Point point;
    private int radius;
    private final double PI = 3.14159265359;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            var error = new NegativeRadiusException("");
            throw error;
        }
        return radius * radius * PI;
    }
}
// END
