package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ0608 {
    public static class BOJ11047 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken()); // 주어지는 동전의 개수
            int N = Integer.parseInt(st.nextToken()); // 목표금액 N

            int[] kArr = new int[K];

            for (int i = 0; i < K; i++) {
                kArr[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;

            for (int i = kArr.length - 1; i >= 0; i--) {
                if (kArr[i] <= N){
                    while (N >= kArr[i]){
                        N -= kArr[i];
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static class BOJ11726 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int[] dp = new int[1001];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++)
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

            System.out.println(dp[n]);

        }
    }

    // TODO: 2023/06/08 다시 풀어봐

    public static class BOJ1931 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine()); // 회의의 수

            int[][] meetings = new int[N][2]; // 입력수만큼, 시작 종료 시간 받아준다

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
                meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
            }

            // 종료시간 기준으로 정렬, 종료시간 같다면 시작 시간으로 비교

            Arrays.sort(meetings, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }

                    return o1[1] - o2[1];
                }
            });

            int count = 0;
            int prevEndTime = 0;

            //1 4
            //3 5
            //0 6
            //5 7
            //3 8
            //5 9
            //6 10
            //8 11
            //8 12
            //2 13
            //12 14

            // 딱 이렇게 정렬되고
            // 1,4 -> 4보다 더 큰 5,7 -> 7보다 큰 8,11 -> 11보다 큰 12,14 이렇게 4번 카운트됨

            for (int i = 0; i < N; i++) {
                if (meetings[i][0] >= prevEndTime){ // 시작시간이 직전 종료 시간보다 같거나 크다면
                    prevEndTime = meetings[i][1]; // prevEndTime 갱신하고
                    count++; // 카운트
                }
            }

            System.out.println(count);
        }
    }

    // TODO: 2023/06/08 다시

    public static class BOJ1541{
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int sum = Integer.MAX_VALUE;    // 초기 상태 여부 확인을 위한 값으로 설정
            StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

            while (subtraction.hasMoreTokens()) {
                int temp = 0;

                // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
                StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

                // 덧셈으로 나뉜 토큰들을 모두 더한다.
                while (addition.hasMoreTokens()) {
                    temp += Integer.parseInt(addition.nextToken());
                }

                // 만약 첫번째 녀석이면 temp로! 예를 들어
                if (sum == Integer.MAX_VALUE) {
                    sum = temp;
                } else {
                    sum -= temp;
                }
            }
            System.out.println(sum);
        }
    }

    public static class BOJ11399{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] prefixSum = new int[N+1];

            prefixSum[0] = arr[0];

            //5
            //3 1 4 3 2
            //1 2 3 3 4  // arr[]
            //1 3 6 9 13 // prefixSum[] == 32

            for (int i = 1; i < N; i++) { // N번째 까지의 누적합 구하기 위함
                prefixSum[i] = prefixSum[i-1] + arr[i]; // prefixSum[1] = prefixSum[0] + arr[1]
            }

            int sum = Arrays.stream(prefixSum).sum();

            System.out.println(sum);
        }
    }

    public static class BOJ3273 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); // given

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int K = sc.nextInt(); // target

            Arrays.sort(arr); // 정렬

            //5 12 7 10 9 1 2 3 11 // K = 13
            //1 2 3 5 7 9 10 11 12
            //1 + 12 -> 13 //  2 + 12 -> 2 + 11 -> 13 // 3 + 11 -> 3 + 10 -> 13 ... 투포인터

            int count = 0;

            int startPointer = 0;
            int minusPointer = N - 1; // N 만큼의 크기이므로 인덱스는 - 1

            while (startPointer < minusPointer){
                if (arr[startPointer] + arr[minusPointer] == K){ // 타겟과 동일한 숫자일경우 스타터를 올리고
                    startPointer++;
                    count++;
                } else if (arr[startPointer] + arr[minusPointer] > K) { // 타겟보다 커질경우 마이너스 포인터를 하나 내린다(큰 숫자에서 빼줌)
                    minusPointer--;
                } else { // K보다 작을경우
                    startPointer++;
                }
            }

            System.out.println(count);
        }
    }
}
