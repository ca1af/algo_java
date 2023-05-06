import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Sol0504 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        int turn = 0;
        char last = words[0].charAt(words[0].length() - 1);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (last != word.charAt(0) || set.contains(word)) {
                turn = i % n + 1;
                answer[0] = turn;
                answer[1] = i / n + 1;
                break;
            }
            set.add(word);
            last = word.charAt(word.length() - 1);
        }
        return answer;
    }

    public int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

}

