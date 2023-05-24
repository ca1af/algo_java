package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class Sol5 {
    public String solution(String s) {
        Map<String, String> m = new HashMap<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();
    }
}
