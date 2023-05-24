package programmers;

import java.util.HashMap;
import java.util.Map;

public class SolMors {
    public static String decode(String letter) {
        // 모스부호-영어 소문자 매핑 정보를 담은 HashMap 객체 생성
        HashMap<String, Character> morse = new HashMap<String, Character>();
        morse.put(".-", 'a'); morse.put("-...", 'b'); morse.put("-.-.", 'c');
        morse.put("-..", 'd'); morse.put(".", 'e'); morse.put("..-.", 'f');
        morse.put("--.", 'g'); morse.put("....", 'h'); morse.put("..", 'i');
        morse.put(".---", 'j'); morse.put("-.-", 'k'); morse.put(".-..", 'l');
        morse.put("--", 'm'); morse.put("-.", 'n'); morse.put("---", 'o');
        morse.put(".--.", 'p'); morse.put("--.-", 'q'); morse.put(".-.", 'r');
        morse.put("...", 's'); morse.put("-", 't'); morse.put("..-", 'u');
        morse.put("...-", 'v'); morse.put(".--", 'w'); morse.put("-..-", 'x');
        morse.put("-.--", 'y'); morse.put("--..", 'z');

        String[] words = letter.split(" "); // 입력 문자열을 공백을 기준으로 분할
        StringBuilder result = new StringBuilder(); // 결과 문자열 객체 생성

        for (String word : words) {
            result.append(morse.get(word)); // 모스부호를 영어 소문자로 변환하여 결과 문자열에 추가
        }

        return result.toString();
    }
}
