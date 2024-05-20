package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> tag;

    public Tag(String name, Map<String, String> tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getStringTag() {
        if (!tag.isEmpty()) {
            var result = new StringBuilder(" ");
            for (var entry : tag.entrySet()) {
                result.append(entry.getKey() + "=\"");
                result.append(entry.getValue() + "\" ");
            }
            result.toString();
            var result1 = result.substring(0, result.length() - 1);
            return result1;
        }
        return "";
    }

    public Map<String, String> getTag() {
        return tag;
    }

    public abstract String toString();
}
// END
