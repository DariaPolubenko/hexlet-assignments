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
}
// END
