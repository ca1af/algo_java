package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ0510 {

    public class B24416 {

        static int count = 0;
        static int[] dp;
        static int dpCount = 0;


        static int fibonazzi(int n){
            if (n == 1 || n == 2){
                count++;
                return 1;
            } else return fibonazzi(n-1) + fibonazzi(n-2);
        }

        static int fibonazziDp(int n){
            dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i <= n; i++) {
                dpCount++;
                dp[n] = dp[n-1] + dp[n-2];
            }

            return dp[n];
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int parsedInt = Integer.parseInt(br.readLine());

            fibonazzi(parsedInt);
            fibonazziDp(parsedInt);

            bw.append(String.valueOf(count)).append(" ");
            bw.append(String.valueOf(dpCount));
            bw.flush();
            bw.close();
            br.close();
        }
    }

    public class B11022 {
        public static void main(String args[]) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;

            int parsedInt = Integer.parseInt(br.readLine());

            for (int i = 1; i <= parsedInt; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int parsedInt1 = Integer.parseInt(st.nextToken());
                int parsedInt2 = Integer.parseInt(st.nextToken());
                bw.write("Case #"+i+": ");
                bw.write(parsedInt1 + " + " + parsedInt2 + " = ");
                bw.write(parsedInt1
                        + parsedInt2 +"\n");
            }
            br.close();
            bw.flush();
            bw.close();
        }

    }
}
