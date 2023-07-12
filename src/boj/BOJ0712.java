package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ0712 {
    public static class BOJ1920 {
        static int[] checker;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            checker = new int[N];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                checker[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(checker);

            int M = Integer.parseInt(br.readLine());

            int[] given = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                given[i] = Integer.parseInt(st.nextToken());
            }

            for (int i : given) {
                if (binarySearch(i)){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }

        public static boolean binarySearch(int target) {
            int lo = 0;
            int hi = checker.length - 1;

            while(lo <= hi) {

                int mid = (lo + hi) / 2;    // 중간위치를 구한다.

                if(target < checker[mid]) {
                    hi = mid - 1;
                } else if(target > checker[mid]) {
                    lo = mid + 1;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
}
