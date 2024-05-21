package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {

        var square = 0;
        try {
            square = (int) Math.ceil(circle.getSquare());
            System.out.println(square);
        } catch (Exception e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }

    public static void main(String[] args) throws NegativeRadiusException {
        var point = new Point(1, 2);
        var circle = new Circle(point, 2);

        System.out.println(circle.getSquare());
        System.out.println((int) circle.getSquare());
    }
}
// END
