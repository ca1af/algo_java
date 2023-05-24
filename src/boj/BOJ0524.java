package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ0524 {
    public class BOJ2869{
        public static void main0(String[] args) {
            Scanner sc = new Scanner(System.in);

            int A = sc.nextInt();
            int B = sc.nextInt();

            int N = sc.nextInt();

            int total = 0;
            int days = 0;

            while (total < N){
                total += A;

                if (total <= N){
                    total -= B;
                    days++;
                }
            }

            System.out.println(days);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int A = sc.nextInt();
            int B = sc.nextInt();
            int V = sc.nextInt();

            int days = (V - B) / (A - B); // 총 이동 거리를 하루 이동 거리로 나눈 몫

            if ((V - B) % (A - B) != 0) { // 나머지가 있는 경우 하루를 더 추가
                days++;
            }

            System.out.println(days);
        }
    }

    public class BOJ5086{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while (true){
                int first = sc.nextInt();
                int second = sc.nextInt();

                if (first == 0){
                    break;
                }

                if (first > second && first % second == 0){
                    System.out.println("multiple");
                } else if (first < second && second % first == 0){
                    System.out.println("factor");
                } else {
                    System.out.println("neither");
                }
            }

            sc.close();
        }
    }

    public class BOJ2501 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int target = sc.nextInt();
            int amount = sc.nextInt();

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= target; i++) {
                if (target % i == 0){
                    queue.add(i);
                }
            }

            int answer = 0;

            for (int i = 0; i < amount; i++) {
                if (!queue.isEmpty()){
                    answer = queue.poll();
                } else {
                    answer = 0;
                    break;
                }
            }

            System.out.println(answer);

        }
    }

    public class BOJ2581{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int sum = 0;
            int minPrime = -1;

            for (int i = m; i <= n; i++) {
                if (isPrime(i)) {
                    if (minPrime == -1) {
                        minPrime = i;
                    }
                    sum += i;
                }
            }

            if (minPrime == -1) {
                System.out.println(-1);
            } else {
                System.out.println(sum);
                System.out.println(minPrime);
            }

            scanner.close();
        }

        private static boolean isPrime(int num) {
            if (num < 2) {
                return false;
            }

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

}
