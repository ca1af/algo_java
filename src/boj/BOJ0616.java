package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ0616 {
    // TODO: 2023/06/16 다시 
    public static class BOJ1912 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 숫자의 ㅐㄱ수

            int[] numbers = new int[N]; // 받아온 숫자를 저장할 용도
            int[] spaces = new int[N]; // 구간의 차를 구할거니까 + 1번 인덱스부터 활용하자

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            for (int i = 1; i < spaces.length; i++) {
                // 두개만 더하는 게 아니고, 연속 수 어느것이든 더하는거임.
                // 만약 -인 수면 넘어가고, 아니라면 ...
                int sum = numbers[i] + numbers[i - 1];
                if (sum > max) max = sum;
            }

            System.out.println(max);
        }
    }

    public static class BOJ17609{
        // TODO: 2023/06/16 다시 
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine()); // 입력받는 수



            for (int i = 0; i < N; i++) {
                String line = br.readLine();
            }

        }

        public static boolean isPalindrome(String s){
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)){ // 인덱스이므로 -1
                    return false;
                }
            }

            return true;
        }
    }
}
