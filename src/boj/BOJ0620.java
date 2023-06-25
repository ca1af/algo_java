package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ0620 {
    public static class BOJ20920 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<String, Integer> wordMap = new HashMap<String, Integer>();

            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                if (word.length() < m) continue; // 길이가 m 이하인 단어들 제거

                Integer count = wordMap.getOrDefault(word, 0);
                wordMap.put(word, count + 1); // <단어, 빈도수> 추가
            }
            List<String> words = wordMap.keySet().stream().sorted((o1, o2) -> {
                int c1 = wordMap.get(o1);
                int c2 = wordMap.get(o2);

                if (c1 == c2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
                    }
                    return o2.length() - o1.length(); // 해당 단어의 길이가 길수록 앞에
                }
                return c2 - c1; // 자주 나오는 단어일수록 앞에
            }).collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i)).append("\n");
            }
            System.out.println(sb);
        }
    }

    public static class BOJ1806 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 구하고자 하는 숫자의 개수
            int S = Integer.parseInt(st.nextToken()); // 목표 합

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int given = Integer.parseInt(st.nextToken());
                arr[i] = given;
            }

            int startIdx = 0;
            int endIdx = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            while (true) {
                if (sum >= S) { // 누적합보다 크다면
                    sum -= arr[startIdx++];
                    min = Math.min(endIdx - startIdx, min);
                } else if (endIdx == N) {
                    break;
                } else {
                    sum += arr[endIdx++];
                }
            }

            if (min != Integer.MAX_VALUE) System.out.println(min);
            else System.out.println(0);

        }
    }

    public static class BOJ1904{
        public static void main(String[] args) {
            // 점화식 세워보자
            // 1 { 1 }
            // 2 { 00, 11}
            // 3 { 001, 100, 111} // 2번 녀석에다가 1번 녀석 앞뒤로 붙인 꼴
            // 5 { 0011, 0000, 1001, 1100, 1111} // 3번 녀석에다가 2번의 개수만큼 붙인 꼴
            // 8 { 00111, 00001, 10000, 11100, 11111, 10011, 11001}

            int[] ints = new int[1000001];


            ints[1] = 1;
            ints[2] = 2;
            ints[3] = 3;

            for (int i = 4; i < ints.length; i++) {
                ints[i] = (ints[i-1] + ints[i-2]) % 15746;
            }

            Scanner sc = new Scanner(System.in);

            int i = sc.nextInt();

            System.out.println(ints[i]);
        }
    }

    public static class BOJ9184 {
        static int[][][] dp = new int[21][21][21]; // 20을 넘지 않으므로

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringBuilder sb = new StringBuilder();

            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                // -1 -1 -1 이 나오면 종료
                if (a == -1 && b == -1 && c == -1) {
                    break;
                }

                sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
            }

            System.out.println(sb);
        }

        static int w(int a, int b, int c) {

            // a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
            if(inRange(a, b, c) && dp[a][b][c] != 0) {
                return dp[a][b][c];
            }

            if(a <= 0 || b <= 0 || c <= 0) {
                return 1;
            }

            if(a > 20 || b > 20 || c > 20) {
                return dp[20][20][20] = w(20, 20, 20);
            }

            if(a < b && b < c) {
                return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            }

            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        /*
         *  배열을 참조하려 할 때 a, b, c 중 하나라도 범위 밖의 수가
         *  나올 수 있기 때문에 이를 체크를 해주기 위한 함수다.
         */
        static boolean inRange(int a, int b, int c) {
            return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
        }
    }

    public static class BOJ1912_Tabulation {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[] arr = new int[N];
            int[] dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = arr[0];

            int max = arr[0];

            for (int i = 1; i < dp.length; i++) {
                dp[i] = Math.max(dp[i-1] + arr[i], arr[i]); // 여기가 진짜 핵심인듯...이전까지의 합이 현재 원소보다 적으면 버린다는 개념

                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
        }
    }

    // TODO: 2023/06/22 이거 진짜 이해해보자...잘 모르겠다
    public static class BOJ1912_Memoization{
        static int[] arr;        // 배열
        static Integer[] dp;        // 메모이제이션 할 dp
        static int max;            // 최댓값 변수

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            int N = in.nextInt();

            arr = new int[N];
            dp = new Integer[N];

            for(int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }

            /*
             * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
             * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
             * max또한 첫 번째 원소로 초기화 해준다.
             */
            dp[0] = arr[0];
            max = arr[0];

            // dp의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색
            recur(N - 1);

            System.out.println(max);
        }

        static int recur(int N) {

            // 탐색하지 않은 인덱스라면
            if(dp[N] == null) {
                dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);

                // 해당 dp[N]과 max 중 큰 값으로 max 갱신
                max = Math.max(dp[N], max);
            }

            return dp[N];
        }
    }
}