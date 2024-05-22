package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
@Getter
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws Exception {
        return new ObjectMapper().writeValueAsString(this);
    }

    public static Car unserialize(String car) throws Exception {
        return new ObjectMapper().readValue(car, Car.class);
    }
    // END
}
