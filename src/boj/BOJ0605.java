package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ0605 {
    public static class BOJ4948 {

        // 주어진 입력 n ~ 2n 까지의 소수 찾기
        // 1 이면 1이다 (1~2, 2포함)
        // 1 ≤ n ≤ 123,456
        // 123456 까지의 소수를 모두 찾아놓고, 그냥 리턴만 하면 되는 것 아닐까?
        static int N = 123456 * 2;
        public static void main(String[] args) {

            int[] arr = new int[N + 1];

            Arrays.fill(arr, 1);

            arr[0] = 0;
            arr[1] = 0;

            for (int i = 2; i <= Math.sqrt(N); i++){
                if (arr[i] == 0) continue;
                for (int j = i + i; j <= N; j = i + j){
                    arr[j] = 0;
                }
            }

            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()){
                int given = sc.nextInt();

                if (given == 0) break;

                int sum = 0;

                for (int i = given + 1; i <= given * 2; i++) { // n 보다 크니까
                    sum += arr[i];
                }

                System.out.println(sum);
            }

        }
    }
}
