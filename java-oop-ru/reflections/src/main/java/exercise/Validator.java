package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
        } catch (Exception e) {
            System.out.println("error");
        }

        return notValidFields;
    }

}
// END
