import java.util.Stack;

import java.util.Stack;

class Sol0510 {
    public int solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isCorrectBracket(s)) {
                count++;
            }
            s = rotateString(s);
        }
        return count;
    }

    // 주어진 문자열을 왼쪽으로 1칸 회전시키는 함수
    private String rotateString(String s) {
        StringBuilder rotated = new StringBuilder(s.substring(1));
        rotated.append(s.charAt(0));
        return rotated.toString();
    }

    // 주어진 문자열이 올바른 괄호 문자열인지 판단하는 함수
    private boolean isCorrectBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ']' && top != '[') || (c == ')' && top != '(') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}

