import java.util.Stack;

//배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
// 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
// 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
//
//arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
//arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
//배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
public class Solution3 {
    public String solution1(String s, int n) {
        // char 어레이로 바꿔서 하나하나 +몇 해주면 될듯하다.
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != ' '){
                char newChar = (char) (aChar + n);
                sb.append(newChar);
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

    public String solution(String s, int n) {
        // 빈 문자열이나 null 값이 입력된 경우 예외 처리
        if (s == null || s.length() == 0) {
            return s;
        }

        // 알파벳 대문자와 소문자를 분리해서 배열에 저장
        char[] upperCase = new char[26];
        char[] lowerCase = new char[26];
        for (int i = 0; i < 26; i++) {
            upperCase[i] = (char) ('A' + i);
            lowerCase[i] = (char) ('a' + i);
        }

        // 시저 암호 생성
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 대문자인 경우
            if (c >= 'A' && c <= 'Z') {
                int index = (c - 'A' + n) % 26;
                // index는 0부터 시작하므로 - 'A'
                sb.append(upperCase[index]);
            }
            // 소문자인 경우
            else if (c >= 'a' && c <= 'z') {
                int index = (c - 'a' + n) % 26;
                sb.append(lowerCase[index]);
            }
            // 알파벳이 아닌 경우
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private String caesar(String s, int n) {
        StringBuilder result = new StringBuilder();
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            result.append(ch);
        }
        return result.toString();
    }
}
