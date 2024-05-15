package exercise;

import org.apache.commons.lang3.StringUtils;


// BEGIN
public class ReversedSequence implements CharSequence {
    private String line;

    public ReversedSequence(String line) {
        this.line = StringUtils.reverse(line);
    }
}
// END
