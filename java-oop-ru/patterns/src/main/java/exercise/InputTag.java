package exercise;

// BEGIN
public class TagInterface implements TagInterface {
    private String type;
    private String value;

    public TagInterface(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String render() {
        return "<input type=\"" + this.type + "\" value=\"" + this.value + "\">";
    }
}
// END
