package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static exercise.Car.unserialize;
import static java.nio.file.Files.readString;

// BEGIN
public class App {
    @SneakyThrows
    public static void save(Path path, Car car) {
        var stringJson = car.serialize();
        Files.writeString(path, stringJson);
    }

    @SneakyThrows
    public static Car extract(Path path) {
        var content = readString(path);
        return unserialize(content);
    }
}
// END
