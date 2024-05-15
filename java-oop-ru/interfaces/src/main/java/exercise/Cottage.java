package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    public double getArea() {
        return this.area;
    }
    @Override
    public int compareTo(Home another) {
        var result = this.getArea() > another.getArea() ? 1
                : this.getArea() < another.getArea() ? -1
                : 0;
        return result;
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
// END
