package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) throws RuntimeException {
        var notValidFields = new ArrayList<String>();
        Field[] fields = address.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                var notNull = field.getAnnotation(NotNull.class);
                field.setAccessible(true);
                Object value = field.get(address);

                if (value == null & notNull != null) {
                    String result = field.getName();
                    notValidFields.add(result);
                }
            }
        } catch (Exception e) {}
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws RuntimeException  {
        var notValidFields = validate(address);
        var result = new HashMap<String, List<String>>();
        Field[] fields = address.getClass().getDeclaredFields();

        try {
            for (var field : fields) {
                var nameField = field.getName();

                if (notValidFields.contains(nameField)) {
                    var list = new ArrayList<String>(List.of("can not be null"));
                    result.put(nameField, list);

                } else if (field.isAnnotationPresent(MinLength.class)) {
                    var getMinLength = field.getAnnotation(MinLength.class);
                    var minLength = getMinLength.minLength();
                    field.setAccessible(true);
                    String value = field.get(address) + "";

                    if (value.length() < minLength) {
                        var list = new ArrayList<String>(List.of("length less than " + minLength);
                        result.put(nameField, list);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return result;
    }
}
// END
