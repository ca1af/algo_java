package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ0629 {
    public class BOJ10870 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); // 주어진 수
            int fibo = fibo(N);
            System.out.println(fibo);
        }

        static int fibo(int n) {
            if (n <= 1) {
                return n;
            }
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static class BOJ25501 {
        static int count = 1; // 처음 들어갈 땐 count 세지 않으므로 1로 시작함.
        public static int recursion(String s, int l, int r) {
            if (l >= r) return 1;
            else if (s.charAt(l) != s.charAt(r)) return 0;
            else {
                count++;
                return recursion(s, l + 1, r - 1);
            }
        }

        public static int isPalindrome(String s) {
            return recursion(s, 0, s.length() - 1);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 주어지는 케이스 개수

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                int palindrome = isPalindrome(s);
                System.out.println(palindrome + " " + count);
                count = 1;
            }
        }
    }
}
