package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String text;
    private TagInterface child;

    public LabelTag(String tag, TagInterface child) {
        this.text = tag;
        this.child = child;
    }

    public String render() {
        return "<label>" + text + child.render() + "</label>";
    }
}
// END
