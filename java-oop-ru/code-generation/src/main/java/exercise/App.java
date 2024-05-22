package exercise;

import lombok.SneakyThrows;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static exercise.Car.unserialize;
import static java.nio.file.Files.readString;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws Exception {
        var stringJson = car.serialize();
        Files.writeString(path, stringJson);
    }


    public static Car extract(Path path) throws Exception {
        var content = readString(path);
        return Car.unserialize(content);
    }
}
// END
