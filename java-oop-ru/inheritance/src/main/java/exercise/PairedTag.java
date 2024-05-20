package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> child;

    public PairedTag(String name, Map<String, String> tag, String tagBody, List<Tag> child) {
        super(name, tag);
        this.tagBody = tagBody;
        this.child = child;
    }

    @Override
    public String toString() {
        if (child.isEmpty()) {
            return "<" + getName() + getStringTag() + ">" + tagBody + "</" + getName() + ">";
        } else {
            return "<" + getName() + getStringTag() + ">" + tagBody + toStringChildList() + "</" + getName() + ">";
        }
        //return "";
    }

    public String toStringChildList() {
        var result = new StringBuilder();
        for (var children : child) {
            result.append(children.toString());
        }
        result.toString();
        var result1 = result.substring(0, result.length() - 2);
        return tagBody + result1 + "\">";
    }
}
// END
