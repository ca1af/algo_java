package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ0613 {
    public static class BOJ1735 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            //  N/M + X/Y = NY + MX / MY 인데, 최대공약수 해줘야함

            int child = (N * Y) + (M * X);
            int parent = (M * Y);

            int gcd = gcd(child, parent); // 최대 공약수

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            child /= gcd;
            parent /= gcd;
            bw.append(String.valueOf(child)).append(" ").append(String.valueOf(parent));
            bw.flush();
        }

        public static int gcd(int a, int b){
            if (b == 0) return a;
            return gcd(b, a%b);
        }
    }
}
