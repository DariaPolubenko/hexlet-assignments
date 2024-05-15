package exercise;

// BEGIN
public class Flat implements Home {
    private Double area;
    private Double balconyArea;
    private int floor;

    public Flat(Double area, Double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public Double getArea() {
        return this.area + this.balconyArea;
    }
    @Override
    public int compareTo(Home another) {
        var result = this.getArea() > another.getArea() ? 1
                : this.getArea() < another.getArea() ? -1
                : 0;
        return 0;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.getArea() + " метров на " + this.floor + " этаже.";
    }
}
// END
