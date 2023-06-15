package boj;

import java.io.*;
import java.util.Stack;

public class BOJ0614 {
    public static class BOJ9012{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 표본의 개수

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                String answer = isCorrect(line);
                bw.append(answer);
                if (i != N - 1){
                    bw.append("\n");
                }
            }

            bw.flush();

            br.close();
            bw.close();

        }

        public static String isCorrect(String line){
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(') stack.push(c);

                else if (stack.isEmpty()) return "NO";

                else stack.pop();
            }

            return stack.isEmpty() ? "YES" : "NO";
        }
    }
}
