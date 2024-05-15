package exercise;

import org.apache.commons.lang3.StringUtils;
import java.lang.CharSequence;


// BEGIN
public class ReversedSequence implements CharSequence {
    private static String line;

    public ReversedSequence(String line) {
        this.line = StringUtils.reverse(line);
    }

    @Override
    public String subSequence(int start, int end) {
       return line.substring(start, end);
    }

    @Override
    public char charAt(int index) {
        return line.charAt(index);
    }

    @Override
    public int length() {
        return line.length();
    }
}
// END
