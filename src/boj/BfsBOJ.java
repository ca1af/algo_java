package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BfsBOJ {
    public static class BOJ2178_0{
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};
        static boolean[][] visited;
        static int[][] edges;
        static int N, M;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // rows
            int M = Integer.parseInt(st.nextToken()); // columns

            edges = new int[N][M]; // rows x columns 배열 ex ) 4 / 6

            for (int i = 0; i < N; i++) {
                String line = br.readLine(); // row 별로 읽을 수 있음 4 / 6 일시 4줄의 로우를 읽으며, 6개씩의 column 을 채움
                for (int j = 0; j < M; j++) {
                    edges[i][j] = line.charAt(j) - '0';
                }
            }

            visited = new boolean[M][N];

            bfs(0, 0);

            System.out.println(edges[N-1][M-1]);
        }

        public static void bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {x,y});

            while(!q.isEmpty()) {
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for(int i=0; i<4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                        continue;
                    if (visited[nextX][nextY] || edges[nextX][nextY] == 0)
                        continue;

                    q.add(new int[] {nextX, nextY});
                    edges[nextX][nextY] = edges[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }



    public static class BOJ2178 {

        static int[][] map;
        static int n;
        static int m;
        static boolean[][] visited;
        static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
        static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for(int i=0; i<n; i++) {
                String s = br.readLine();
                for(int j=0; j<m; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            visited = new boolean[n][m];
            visited[0][0] = true;
            bfs(0, 0);
            System.out.println(map[n-1][m-1]);
        }

        public static void bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {x,y});

            while(!q.isEmpty()) {
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for(int i=0; i<4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                        continue;
                    if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                        continue;

                    q.add(new int[] {nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    // TODO: 2023/06/02 2178 다시풀어
}
