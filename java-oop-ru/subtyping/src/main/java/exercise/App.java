package exercise;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var mapa = storage.toMap();

        for (var current : mapa.entrySet()) {
            storage.unset(current.getKey());
            storage.set(current.getValue(), current.getKey());
        }
    }
}
// END
