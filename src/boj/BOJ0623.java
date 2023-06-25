package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ0623 {
    public static class BOJ2579 {
        // TODO: 2023/06/25 다시풀어! 
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[] scores = new int[N];

            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(br.readLine());
            }

            // currentIdx = 0;
            // += 2 씩 증가하며, -1 인덱스와 비교해서 증가폭을 정한다. -1이 더 크면 currentIdx += 1, 아니면 +=2
            int idx = 0;
            int max = 0;

            while (idx < N){

            }
        }
    }
}
