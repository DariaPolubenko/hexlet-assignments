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
        Field[] fields = address.getClass().getDeclaredFields();

        var result = new HashMap<String, List<String>>();

        try {

            for (var field : fields) {
                if (notValidFields.contains(field)) {
                    var list = new ArrayList<String>();
                    list.add("can not be null");
                    var key = field.getName();
                    result.put(key, list);
                }

                if (field.isAnnotationPresent(MinLength.class)) {
                    var getMinLength = field.getAnnotation(MinLength.class);
                    var minLength = getMinLength.minLength();
                    field.setAccessible(true);
                    String value = field.get(address) + "";

                    if (value.length() < minLength) {
                        var list = new ArrayList<String>();
                        list.add("length less than" + minLength);
                        var key = field.getName();
                        result.put(key, list);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return result;
    }

    public static void main(String[] args) {
        Address address = new Address("USA", "Texas", null, "7", "2");
        System.out.println(advancedValidate(address));
    }

}
// END
