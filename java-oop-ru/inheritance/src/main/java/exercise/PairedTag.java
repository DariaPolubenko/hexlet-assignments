package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> child;

    public PairedTag(String name, Map<String, String> attributes, String tagBody, List<Tag> child) {
        super(name, attributes);
        this.body = tagBody;
        this.child = child;
    }

    @Override
    public String toString() {
            return "<" + getName() + stringifyAttributes() + ">" + body + stringifyChild() + "</" + getName() + ">";
    }

    public String stringifyChild() {
        var result = child.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));

        return result;
    }
}
// END
