package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ0521 {

    public class BOJ1052{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt(); // 물병의 개수
            int K = sc.nextInt(); // 옮길 수 있는 개수 ( 최종 개수 )

            int newBottle = 1;

            while (N > K){
                // 출력예

                // {3, 1} 주어지면, {1,1,1} 이케 있다가 -> {2,1} 이케돼서 물병이 모두 같지가 않다. 따라서 하나 사서 {2,2} 맞춰야함
                // {13, 2} 주어지고 하나 사면 {2} 7개이므로 두개 더 사서 {2,.....} 맞춰져야 함

                // 즉, 이거를 2로 나눈 몫이, 2로 나눠지지 않는다면 N을 계속 ++ 시켜서 2로 나눠지게 하는거지. (뉴보틀로)
                int target = (N / 2) % K;

                if (N / 2 != N % K){
                    N += newBottle;
                } else {
                    break;
                }

                newBottle++;

                if (newBottle > N){
                    newBottle = -1;
                    break;
                }
            }

            System.out.println(newBottle);
        }
    }

    public class BOJ1003_wrong{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            List<Integer> zeroCounts = new ArrayList<>();
            List<Integer> oneCounts = new ArrayList<>();

            while (sc.hasNext()){
                int n = sc.nextInt();
                int zeroCount = 0;
                int oneCount = 0;

                fibonazzi(n, zeroCount, oneCount);

                zeroCounts.add(zeroCount);
                oneCounts.add(oneCount);

                zeroCount = 0;
                oneCount = 0;
            }
        }

        static int fibonazzi(int n, int zeroCount, int oneCount){
            if (n == 0){
                zeroCount++;
                return 0;
            } else if (n == 1) {
                oneCount++;
                return 1;
            } else {
                return fibonazzi(n-1, zeroCount, oneCount) + fibonazzi(n-2, zeroCount, oneCount);
            }
        }




    }
    public class BOJ1003 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt();

            int[][] dp = new int[41][2];
            dp[0][0] = 1; // 초기값: N=0일 때의 0의 개수
            dp[0][1] = 0; // 초기값: N=0일 때의 1의 개수
            dp[1][0] = 0; // 초기값: N=1일 때의 0의 개수
            dp[1][1] = 1; // 초기값: N=1일 때의 1의 개수

            for (int i = 2; i <= 40; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0]; // N일 때의 0의 개수는 N-1일 때와 N-2일 때의 0의 개수 합산
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1]; // N일 때의 1의 개수는 N-1일 때와 N-2일 때의 1의 개수 합산
            }

            while (T-- > 0) {
                int n = sc.nextInt();
                System.out.println(dp[n][0] + " " + dp[n][1]);
            }
        }
    }



}
