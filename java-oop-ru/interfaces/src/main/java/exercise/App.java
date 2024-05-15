package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int n) {

        var sortedList = list.stream()
                .sorted((h1, h2) -> h1.compareTo(h2))
                .limit(n)
                .map(home -> home.toString())
                .toList();

        return sortedList;
    }

}
