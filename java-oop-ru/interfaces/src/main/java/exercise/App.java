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
                .flatMap(home -> home.toString())
                .toList();

        var result = new ArrayList<String>();
        for (var i = 0; i < n; i++) {
            result.add(sortedList.get(i));
        }
        return result;
    }

}
