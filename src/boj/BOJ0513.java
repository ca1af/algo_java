package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ0513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int parsedInt = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] triangle = new int[parsedInt][parsedInt];

        for (int i = 0; i < parsedInt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[parsedInt][parsedInt];

        dp[0][0] = triangle[0][0];



    }
}
