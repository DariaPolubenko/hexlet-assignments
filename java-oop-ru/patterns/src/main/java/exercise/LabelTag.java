package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface label;

    public LabelTag(String tag, TagInterface label) {
        this.tag = tag;
        this.label = label;
    }

    public String render() {
        return "<label>" + this.tag + this.label.render() + "</label>";
    }
}
// END
