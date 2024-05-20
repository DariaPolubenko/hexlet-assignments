package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> tag) {
        super(name, tag);
    }

    @Override
    public String toString() {
        if (getStringTag().isEmpty()) {
            return "<" + this.getName() + ">";
        }
        return "<" + this.getName() + getStringTag() + ">";
    }

    public String toStringChild() {
        if (getStringTag().isEmpty()) {
            return "";
        }
        return "<" + getName() + getStringTag() + ">";
    }

}
// END
