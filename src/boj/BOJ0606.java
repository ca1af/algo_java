package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ0606 {
    public static class BOJ17103 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            boolean[] primes = new boolean[1000001];
            primes[0] = primes[1] = true;

            // 에라토스테네스의 체
            for (int i = 2; i * i <= 1000000; i++) {
                if (!primes[i]) {
                    for (int j = i * i; j <= 1000000; j += i) {
                        primes[j] = true;
                    }
                }
            }

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                int count = 0;

                for (int i = 2; i <= n / 2; i++) {
                    if (!primes[i] && !primes[n - i]) { // if N = 10, i = 3 -> primes[3], primes[7] 트루니까 카운트 +
                        count++;
                    }
                }

                System.out.println(count);
            }
        }
    }

    public class BOJ18870{
        public static void main(String[] args) {
            // 주어진 수 N 개 만큼의 가중 평균을 구해라
            // 1. 입력받기
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // 2. 클론 배열 만들고, 클론은 sort 하기

            //2 4 -10 4 -9 arr
            //-10 -9 2 4 4 clone

            int[] clone = arr.clone();
            Arrays.sort(clone);

            HashMap<Integer, Integer> map = new HashMap<>();

            int idx = 0;

            // map에 해당 키가 없다면(중복되지 않게 하기 위함 ex) 4,4 같은 키면 그냥 동일 인덱스로 설정함
            for (int i = 0; i < clone.length; i++) {
                if (!map.containsKey(clone[i])){
                    map.put(arr[i], idx++);
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                sb.append(map.get(i)).append(" ");
            }

            System.out.println(sb.toString());

        }
    }

    public class BOJ11279 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // Max heap

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(br.readLine());

                if (x == 0) {
                    if (pq.isEmpty()) {
                        sb.append("0\n");
                    } else {
                        sb.append(pq.poll()).append("\n");
                    }
                } else {
                    pq.offer(x);
                }
            }

            System.out.println(sb.toString());
        }
    }


}
