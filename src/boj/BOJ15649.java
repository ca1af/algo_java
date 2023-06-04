package boj;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15649 {

    public static class Main {

        static int N, M;
        static int[] permutation;
        static boolean[] visited;
        static BufferedWriter bw;

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = sc.nextInt();
            M = sc.nextInt();

            permutation = new int[M];
            visited = new boolean[N + 1];

            backtrack(0);

            bw.flush();
            bw.close();
        }

        public static void backtrack(int depth) throws IOException {
            if (depth == M) {
                // 순열을 모두 구한 경우 출력
                for (int i = 0; i < M; i++) {
                    bw.write(permutation[i] + " ");
                }
                bw.write("\n");
                return;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    permutation[depth] = i;
                    backtrack(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static class BOj1018_0{

        // 체스판이 입력으로 주어짐 M * N
        // a. 체스판이 백으로 시작하는 경우 / b. 체스판이 흑으로 시작하는 경우 가 있을듯. 둘 중에 적은 걸 찾아야 함
        // 컨셉

        // 1. 주어진 체스판 이중배열의 첫번째 row 부터 돌면서, i % 2 == 0 이면 백, 아니면 흑 이런식으로 하고
        // 2. 반복문의 패턴을 바꿔준다 (첫째줄이면 짝백, 둘째줄이면 짝흑) for for 해서, 밖의 for문에서 판별하는 (매서드로 두개 빼야할듯)
        //
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 반복문 횟수 ( 몇번나오니)
            int M = Integer.parseInt(st.nextToken()); // 칼럼 의 길이

            char[][] chars = new char[N][M];


            for (int i = 0; i < N; i++) { // 반복횟수만큼 (주어진 칼럼만큼)
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    chars[i][j] = s.charAt(j);
                }
            }

            int answer1 = 0;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0){ // 짝수로우면
                    answer1 += isStartWithWhite(chars[i]);
                } else {
                    answer1 += isStartWithBlack(chars[i]);
                }
            }

            int answer2 = 0;

            for (int i = 0; i < N; i++) {
                if (i % 2 == 0){ // 짝수로우면
                    answer2 += isStartWithBlack(chars[i]);
                } else {
                    answer2 += isStartWithWhite(chars[i]);
                }
            }

            int answer = Math.min(answer1, answer2);

            System.out.println("answer1 : " + answer1 + ", answer : " + answer2);

            System.out.println(answer);
        }

        public static int isStartWithWhite(char[] row){
            int answer = 0;
            for (int i = 0; i < row.length; i++) {
                if (i % 2 == 0){ // 짝수놈들이
                    if (row[i] == 'W'){ // 백이면 (잘못된거면)
                        answer++;
                    }
                } else {
                    if (row[i] == 'B'){// 홀수인데 백이면
                        answer++;
                    }
                }
            }
            return answer;
        }

        public static int isStartWithBlack(char[] row){
            int answer = 0;
            for (int i = 0; i < row.length; i++) {
                if (i % 2 == 0){ // 짝수놈들이
                    if (row[i] == 'B'){ // 흑 (잘못된거면)
                        answer++;
                    }
                } else {
                    if (row[i] == 'W'){// 백
                        answer++;
                    }
                }
            }
            return answer;
        }
    }

    public static class BOj1018 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 행의 개수
            int M = Integer.parseInt(st.nextToken()); // 열의 개수

            char[][] board = new char[N][M];

            // 체스판 입력 받기
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = s.charAt(j);
                }
            }

            int minCount = Integer.MAX_VALUE;

            // 체스판을 만들어가면서 최소 개수 찾기
            for (int i = 0; i <= N - 8; i++) {
                for (int j = 0; j <= M - 8; j++) {
                    int count1 = countChanges(board, i, j, 'W'); // 백으로 시작하는 경우
                    int count2 = countChanges(board, i, j, 'B'); // 흑으로 시작하는 경우
                    int min = Math.min(count1, count2);
                    minCount = Math.min(minCount, min);
                }
            }

            System.out.println(minCount);
        }

        public static int countChanges(char[][] board, int startRow, int startCol, char startChar) {
            int count = 0;
            char currChar = startChar;

            for (int i = startRow; i < startRow + 8; i++) {
                for (int j = startCol; j < startCol + 8; j++) {
                    if (board[i][j] != currChar) {
                        count++;
                    }
                    currChar = (currChar == 'W') ? 'B' : 'W';
                }
                currChar = (currChar == 'W') ? 'B' : 'W'; // 다음 행은 현재 열과 반대로 시작
            }

            return count;
        }
    }

}
