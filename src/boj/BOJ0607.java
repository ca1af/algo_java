package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.*;

public class BOJ0607 {

    public class BOJ2108 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            int[] count = new int[8001];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
                count[numbers[i] + 4000]++;
                sum += numbers[i];
            }

            Arrays.sort(numbers);

            int maxCount = 0;
            int mode = 0;
            boolean isSecond = false;

            for (int i = 0; i < 8001; i++) {
                if (count[i] > maxCount) {
                    maxCount = count[i];
                    mode = i - 4000;
                    isSecond = false;
                } else if (count[i] == maxCount && !isSecond) {
                    mode = i - 4000;
                    isSecond = true;
                }
            }

            int mean = (int) Math.round((double) sum / N);
            int median = numbers[N / 2];
            int range = numbers[N - 1] - numbers[0];

            System.out.println(mean);
            System.out.println(median);
            System.out.println(mode);
            System.out.println(range);
        }
    }

    public class BOJ11866 {
        public static void main(String[] args) {
            // 7, 3 -> <3, 6, 2, 7, 5, 1, 4>

            // 큐에다가 1~N까지 넣고
            // k - 1 만큼 폴한다음에 다시 큐에 집어넣기
            // 1,2,3 ... -> 2,3,4... -> 3,4,5... -> poll! 후 반복

            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt(); // N
            int K = scanner.nextInt(); // K

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                queue.offer(i);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("<");

            while (!queue.isEmpty()) {
                for (int i = 0; i < K - 1; i++) {
                    queue.offer(queue.poll());
                }
                sb.append(queue.poll());

                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            }

            sb.append(">");
            System.out.println(sb.toString());
        }
    }

    public class BOJ10773 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int K = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < K; i++) {
                int number = Integer.parseInt(br.readLine());
                if (number == 0) {
                    stack.pop();
                } else {
                    stack.push(number);
                }
            }

            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            System.out.println(sum);
        }
    }

    public static class BOJ9461 {
        public static void main(String[] args) {
            //1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12 --> 6 "번쨰" 구해라고하면 -> 3 (인덱스 아니라 인덱스 - 1 번째)
            //0, 1, 2, 3, 4 까지는 미리 선언
            // 그 후는 arr[N] = arr[N-1] + arr[N-5] //

            // N의 범위는 100까지.

            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();

            long[] dp = new long[101]; // 범위 틀렸었음

            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;

            for (int i = 6; i <= 100; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            StringBuilder sb = new StringBuilder();

            while (T-- > 0) {
                int N = scanner.nextInt();
                sb.append(dp[N]).append("\n");
            }

            System.out.println(sb.toString());
        }
    }
}

