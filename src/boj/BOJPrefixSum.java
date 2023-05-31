package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJPrefixSum {
    public static class BOJ11659 {
        // https://www.acmicpc.net/problem/11659
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int M = sc.nextInt(); // 배열의 길이
            int N = sc.nextInt(); // 구간합 구해야 하는 개수

            int[] arr = new int[M];

            for (int i = 0; i < M; i++) {
                arr[i] = sc.nextInt();
            }

            int[] preFixSum = new int[M];

            preFixSum[0] = arr[0];

            // 5,4,3,2,1 인 경우
            // prefixSum[0] = 5;
            // prefixSum[1] = 5 + 4 = 9
            // prefixSum[2] = 9 + 3 = 12
            // ... 14
            // prefixSum[4] = 14 + 1 = 15

            for (int i = 1; i < arr.length; i++) {
                preFixSum[i] = preFixSum[i - 1] + arr[i];
            }

            for (int i = 0; i < N; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                // 1 3 : 12 --> 12
                // 2 4: 9 --> 14 - 5 = 9

                // 구간합 계산
                // 인덱스를 0부터 해서 toIdx -1, from 인덱스는 1 이상일경우 -2, 아니면 0
                int sum = preFixSum[to - 1] - (from > 1 ? preFixSum[from - 2] : 0);

                System.out.println(sum);
            }
        }

        static int[] array;

        public static void main0(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            array = new int[n + 1];
            for (int i = 1; i <= n; i++) { // i까지의 누적합 구하기
                array[i] = array[i - 1] + Integer.parseInt(st.nextToken());
                System.out.println(array[i]);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                // a, b사이의 구간합은 array[b]-array[a-1]과 같다
//                System.out.println(array[b]-array[a-1]);
            }
        }
    }

    // TODO: 2023/05/31 BOJ 10986 못풀었음
    public static class BOJ10986 {
        public static void main0(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt(); // 주어지는 정수 개수
            int M = sc.nextInt(); // 나눌 수

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int[] prefixSum = new int[N + 1];

            for (int i = 1; i < arr.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }

            int count = 0;

            for (int i = 0; i < prefixSum.length; i++) {
                int sum = 0;
                int fromIdx = i;
                int toIdx = prefixSum.length - 1;
                // 투포인터까지 적용시킨다면?

                while (fromIdx < toIdx) {
                    if (sum % M == 0) {
                        count++;
                        sum -= prefixSum[fromIdx];
                        fromIdx++;
                    } else {
                        sum += prefixSum[fromIdx + 1];
                    }
                }

            }

            System.out.println(count);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt(); // 주어지는 정수 개수
            int M = sc.nextInt(); // 나눌 수

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int[] prefixSum = new int[N];

            prefixSum[0] = arr[0];

            for (int i = 1; i < N; i++) {
                prefixSum[i] = (prefixSum[i - 1] + arr[i]) % M;
            }

            int[] remainderCount = new int[M];
            long count = 0;

            for (int i = 0; i < N; i++) {
                count += remainderCount[prefixSum[i]];
                remainderCount[prefixSum[i]]++;
            }

            System.out.println(count);
        }
    }

    public class BOJ2559{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 전체 날짜 수
            int K = Integer.parseInt(st.nextToken()); // 구간 합

            // 5, 3 -> 0,1,2 // 1,2,3 // 2,3,4

            // 0,1,2 맞네

            int[] arr = new int[N];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] prefixSum = new int[N];

            prefixSum[0] = arr[0];

            for (int i = 1; i < N; i++) {
                prefixSum[i] = prefixSum[i-1] + arr[i];
            }

            int max = 0;

            //10 2 --> 21

            //1  2  3  4 5 6 7 8  9 10
            //3 -2 -4 -9 0 3 7 13 8 -3

            // 9+8이 젤큼

            //21
            //1  2   3   4    5    6   7   8  9   10
            //3, 1, -3, -12, -12, -9, -2, 11, 19, 16

            // 아이가 7이라면?
            // 8번 인덱스, 6번 인덱스

            for (int i = 0; i < prefixSum.length - K + 1; i++) {
                int sum = prefixSum[i + K - 1] - (i > 0 ? prefixSum[i - 1] : 0);
                if (sum > max){
                    max = sum;
                }
            }

            System.out.println(max);
        }
    }

}
