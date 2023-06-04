package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BfsBOJ {
    public static class BOJ2178_0 {
        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};
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

            System.out.println(edges[N - 1][M - 1]);
        }

        public static void bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x, y});

            while (!q.isEmpty()) {
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                        continue;
                    if (visited[nextX][nextY] || edges[nextX][nextY] == 0)
                        continue;

                    q.add(new int[]{nextX, nextY});
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
        static int[] dx = {-1, 1, 0, 0}; //x방향배열-상하
        static int[] dy = {0, 0, -1, 1}; //y방향배열-좌우

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            visited = new boolean[n][m];
            visited[0][0] = true;
            bfs(0, 0);
            System.out.println(map[n - 1][m - 1]);
        }

        public static void bfs(int x, int y) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x, y});

            while (!q.isEmpty()) {
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                        continue;
                    if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                        continue;

                    q.add(new int[]{nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    // TODO: 2023/06/02 2178 다시풀어


    public static class BOJ1926 {

        static int[][] map;
        static boolean[][] visited;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static int N, M;
        static int count = 0;
        static int time = 0;

        public static void main(String[] args) throws IOException {
            // 입력으로 주어진 2중배열 돌면서, 해당하는 요소가 1이고 방문한 적 없다면 BFS 시작하며 time 을 +1한다.
            // bfs 를 돌면서 visted[] 를 true 로 만들 때마다 count 를 +1 한다. 만약 기존에 정의된 카운트보다 크다면, 카운트를 바꾼다

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][M + 1];

            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < M + 1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[N + 1][M + 1];

            int max = -1;

            // 위치와 인덱스를 맞춰주기 위해서 둘 다 +1

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) { // 1부터 시작하므로...
                    if (map[i][j] == 1 && !visited[i][j]) { // 1이고 안들렀다면... 왜 근데 안되는것?
                        bfs(i, j);
                        max = Math.max(count, max);
                        // 카운트 재할당하면서...젤큰놈으로
                        time++;
                        count = 0; // count 다시 0으로 돌려주기
                    }
                }
            }

            System.out.println(time);
            System.out.println(max);
        }

        public static void bfs(int a, int b) {
            Queue<int[]> q = new LinkedList<>();

            visited[a][b] = true;
            count++; // 들렀으므로 카운트 +1

            q.add(new int[]{a, b});

            while (!q.isEmpty()) {
                int[] polled = q.poll();

                for (int i = 0; i < 4; i++) {
                    int x = polled[0] + dx[i];
                    int y = polled[1] + dy[i];

                    if (x < 1 || y < 1 || x > N || y > M) continue;  // 못가는곳이면 안간다 - 범위 초과 경우(인덱스 1부터 시작하므로 1 이하면 안됨)
                    if (map[x][y] != 0 && !visited[x][y]) { // 갈 수 있는 곳이라면, 아직 안들렀다
                        visited[x][y] = true;
                        count++; // 들렀으므로 카운트 +1
                        q.add(new int[]{x, y}); // 새걸로 다시 넣어줌
                    }
                }
            }
        }
    }


    public static class BOJ15649 {
        static boolean[] visited;
        static int[] map;
        static int N,M;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt(); //  1 ~ N 까지의 자연 수 중에서
            M = sc.nextInt(); //  중복 없이 만들 수 있는 M 길이의 수열

            visited = new boolean[10];
            map = new int[10];

            // 1, 2, 3 에 2면
            // 1, 2 / 1, 3 / 2, 1 / 2, 3  / 3 ,1 / 3, 2 일케 셋 되겠지? (양방향)
            // 그렇다면, 연결 리스트에 양방향 뭔가를 추가하는 일이 되겠네
        }

        public static void dfs(int idx){ // 현재 자리수
            if (idx == M){
                for (int i = 0; i < map.length; i++) {
                    System.out.println(map[i] + " ");
                }
                System.out.println();
                return;
            }

            for (int i =1; i <= N; i++) { // 자릿수마다 반복
                if (!visited[i]){
                    visited[i] = true;

                    map[idx] = i; // 배열에 해당 자릿수 입력
                    dfs(idx + 1);
                }

            }
        }
    }

    public class BOJ1977{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int M = sc.nextInt();


            for (int i = M; i <= N; i++) { //이하니까 포함

            }
        }
    }

    public static class BOJ27433 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int given = sc.nextInt();

            long fact = fact(given);

            System.out.println(fact);
        }

        public static long fact(int given){
            if (given == 1){
                return 1;
            }
            return given * fact(given - 1);
        }
    }
}
