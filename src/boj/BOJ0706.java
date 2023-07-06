package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ0706 {
    // TODO: 2023/07/06 다시!
    public static class BOJ2512 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr); // 순서대로 정렬
            int total = 0;

            for (int j : arr) {
                total += j;
            }

            int budget = Integer.parseInt(br.readLine()); // 예산 입력받기

            int answer = 0;

            //120 110 140 150 total  = 230 290 = 520 / 4 = 130 정도. 이거보다 낮으면 걍 뺀다 -> 뺀 후에, 남는 예산을 남은 원소의 개수만큼 나눠.
            //485

            int mid = total / 4; // 평균값

            int count = 0; // 평균값보다 높게 부른 녀석들의 개수

            if (total <= budget){
                answer = arr[N-1]; // 걍 젤큰게 최고예산됨
            } else {
                for (int i = 0; i < N; i++) {
                    if (arr[i] < mid) budget -= arr[i];
                    else {
                        count++;
                    }
                }
                answer = budget / count;
            }

            System.out.println(answer);
        }
    }


    public static class BOJ2512_Cor{
        private static int[] arr; // 지방 예산
        private static long answer = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); // 지방의 수
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long M = sc.nextLong(); //총 예산
            long left = 0;
            long right = arr[N-1];

            while (left <= right) {
                long mid = (left + right) / 2; //내야할 세금
                long sum = 0; // 모든 지방 세금 합
                for (int money : arr) {
                    if (money >= mid) sum += mid; //내라는 세금 낼 수 있는 지방
                    else sum += money; //못내는 지방은 가진 최대 돈만 냄
                }
                if (sum > M) { // 내라는 세금 보다 많은 경우 -> 세금을  줄여본다.
                    right = mid - 1;
                } else { // 내라는 세금보다 적은 경우 -> 세금을 높여서 더 최고의 경우의 수를 찾는다.
                    left = mid + 1;
                    answer = Math.max(answer, mid);
                }
            }
            System.out.println(answer);
        }
    }
}
