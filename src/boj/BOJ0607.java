package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    public class BOJ11866{
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

}
