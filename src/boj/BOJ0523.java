package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ0523 {
    public class BOJ25206{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();

            System.out.println(s);
        }

    }

    public class BOJ2738{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] matrix1 = new int[n][m];
            int[][] matrix2 = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }

            int[][] answer = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public class BOJ2566 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int[][] answer = new int[9][9];

            int temp = 0;
            int a = 0;
            int b = 0;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int max = sc.nextInt();
                    if (max > temp){
                        temp = max;
                        a = i;
                        b = j;
                    }
                    answer[i][j] = sc.nextInt();
                }
            }

            System.out.println(temp);
            System.out.println(a + " " + b);
        }
    }

    public class BOJ2720 {
        public static void main0(String[] args) {
            Scanner sc = new Scanner(System.in);

            int count = sc.nextInt();

            int[] rests = new int[count];

            for (int i = 0; i < count; i++) {
                rests[i] = sc.nextInt();
            }

            int quarter = 25;
            int dime = 10;
            int nickel = 5;
            int penny = 1;

            // ex 124 -> 4, 2, 0, 4;

            int[][] answer = new int[4][count];

            for (int i = 0; i < rests.length; i++) {
                int rest = rests[i];
                answer[0][i] = rest / quarter;
                rest %= quarter;

                answer[1][i] = rest / dime;
                rest %= dime;

                answer[0][i] = rest / nickel;
                rest %= nickel;

                answer[1][i] = rest / penny;
            }

            for (int i = 0; i < answer.length; i++) {
                for (int i1 = 0; i1 < answer.length; i1++) {

                }
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int T = scanner.nextInt(); // 테스트 케이스의 개수

            for (int i = 0; i < T; i++) {
                int C = scanner.nextInt(); // 거스름돈

                // 각 동전의 개수 계산
                int q = C / 25;
                C %= 25;

                int d = C / 10;
                C %= 10;

                int n = C / 5;
                C %= 5;

                int p = C;

                System.out.println(q + " " + d + " " + n + " " + p);
            }
        }
    }


}
