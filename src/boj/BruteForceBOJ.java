package boj;

import java.util.Scanner;

public class BruteForceBOJ {
    public class BOJ2231{
        public static void main0(String[] args) {
            Scanner sc = new Scanner(System.in);

            int target = sc.nextInt();

            int sum = 0;

            int answer = 0;

            for (int i = 0; i < target; i++) {
                char[] charArray = Integer.toString(i).toCharArray();
                for (char c : charArray) {
                    sum += (c - '0');
                    if (sum == target){
                        answer = i;
                        break;
                    }
                }
            }

            System.out.println(answer);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int target = sc.nextInt();

            int answer = 0;

            for (int i = 1; i < target; i++) {
                int sum = i;
                int num = i;

                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }

                if (sum == target) {
                    answer = i;
                    break;
                }
            }

            System.out.println(answer);
        }

    }
    //https://www.acmicpc.net/problem/19532
    public class BOJ19532 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();
        }
    }


}
