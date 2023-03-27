import java.util.Arrays;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/12909 프로그래머스 "올바른 괄호"

//괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
//"()()" 또는 "(())()" 는 올바른 괄호입니다.
//")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
//'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

public class Solution2 {
    boolean solution(String s) {
        boolean answer = true;

        // 아이디어

        // 1. 일단 ( 랑 ) 개수가 맞아야함
        // 2. 처음부터 탐색한다면 (가 나온 개수랑 )가 나온 개수가 맞아야하고, 맞으면 일단 제외시켜야 한다. 제외시켰을 때 예외가 있다면 false인거지.

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}