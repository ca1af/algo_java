package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ0628 {
    public static class BOJ1026{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[] firstArr = new int[N];
            Integer[] secondArr = new Integer[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                firstArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                secondArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(firstArr); // 첫째거는 정순
            Arrays.sort(secondArr, Comparator.reverseOrder());

            int answer = 0;

            for (int i = 0; i < firstArr.length; i++) {
                answer += firstArr[i] * secondArr[i];
            }

            System.out.println(answer);
        }
    }
}
