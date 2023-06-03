package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ0602 {
    public static class BOJ1260 {
        static ArrayList<Integer>[] edges;
        static int[] visited; // 들린 순서를 출력해주기 위해서 인트로
        static int count = 1;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // node
            int M = Integer.parseInt(st.nextToken()); // edge
            int V = Integer.parseInt(st.nextToken()); // starting point

            edges = new ArrayList[N + 1];

            for (int i = 1; i < N + 1; i++) {
                edges[i] = new ArrayList<>(); // 1부터 N 까지의 노드 저장
            }

            visited = new int[N + 1];
            Arrays.fill(visited, 0); // 0번 인덱스도 0으로 초기화 된거 알아야함

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edges[start].add(end);
                edges[end].add(start);
                // 인접 리스트 완성, 방향성 없으므로 양방향으로 선언
            }

            for (int i = 1; i < N + 1; i++) {
                Collections.sort(edges[i]);
            }

            dfs(V);

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < visited.length; i++) {
                sb.append(visited[i]).append(" ");
            }

            Arrays.fill(visited, 0); // 출력 후 다시 초기화

            count = 1; // 카운트도 재초기화

            sb.append("\n"); // 공백하나 주기

            bfs(V);

            for (int i = 1; i < visited.length; i++) {
                sb.append(visited[i]).append(" ");
            }

            System.out.println(sb.toString());
        }

        public static void dfs(int node) {
            // 현재 방문순서( 3번이 먼저면 3번 인덱스에 1이오게) 찍히는데, "번호"순서로 찍어야함
            visited[node] += count;
            count++;
            for (Integer integer : edges[node]) {
                // 이거 왜하는? 인접리스트[노드] 가져와서, 뭐가 연결되어있는지 보려고
                // ex 3 -> 1, 2 이런식이겠지
                if (visited[integer] == 0) {// 안들렀다면
                    dfs(integer);
                }
            }
        }

        public static void bfs(int node) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node); // 첫 노드 큐에 저장.
            visited[node] += count;

            while (!queue.isEmpty()) {
                int poll = queue.poll();
                for (Integer integer : edges[poll]) {
                    if (visited[integer] == 0) {
                        visited[integer] += ++count;
                        queue.add(integer);
                    }
                }
            }
        }

    }


    public static class BOJ1929 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int M = sc.nextInt(); // start
            int N = sc.nextInt(); // end

            int[] arr = new int[N + 1];

            for (int i = 2; i < arr.length; i++) {
                arr[i] = i;
            }

            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (arr[i] == 0) continue;
                for (int j = i + i; j <= N; j = i + j) {
                    arr[j] = 0;
                }
            }

            for (int i = M; i <= N; i++) {
                if (arr[i] != 0) {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    public static class BOJ2178 {
        static int N, M;
        static int[][] map;
        static boolean[][] visited;
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // N rows
            M = Integer.parseInt(st.nextToken()); // M columns

            map = new int[N][M]; // map 초기화
            visited = new boolean[N][M]; // visited 초기화

            for (int i = 0; i < N; i++) { // map 배열 값 채워줌
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            bfs(0, 0);

            System.out.println(map[N-1][M-1]);
        }

        public static void bfs(int a, int b) {
            visited[a][b] = true; // 들어왔으므로 들렀다는 표시 남겨

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[] {a,b});

            while (!queue.isEmpty()){
                int[] first = queue.poll();
                int startX = first[0];
                int startY = first[1];
                for (int i = 0; i < 4; i++){ // 움직일 수 있는 경우의 수동안 옮겨다니기
                    int newX = startX + dx[i];
                    int newY = startY + dy[i];
                    // 이제 여기서 실제 그래프탐색을 해야 하는거지
                    if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue; // 맵을 나가는경우 무시

                    if (visited[newX][newY] || map[newX][newY] == 0) continue; // 이미 들렀거나 갈 수 없는 칸인경우 무시

                    queue.add(new int[] {newX, newY});
                    map[newX][newY] = map[startX][startY] + 1;
                    visited[newX][newY] = true;
                }


            }
        }
    }

    public class BOJ1260_0 {
        static ArrayList<Integer>[] map;
        static boolean[] visited;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //node
            int M = Integer.parseInt(st.nextToken()); //edge
            int V = Integer.parseInt(st.nextToken()); //starting point

            map = new ArrayList[N + 1];

            for (int i = 1; i <= map.length; i++) { // N + 1 노드까지. 0번노드 없는것으로 침
                map[i] = new ArrayList<>();
            }

            visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map[start].add(end);
                map[end].add(start); // 양방향 노드정보 추가
            }


        }

        public static void DFS(int node){
            visited[node] = true;

            for (Integer integer : map[node]) { // 입력된 node와 연결된 녀석들 찾기
                if (visited[integer]) continue;
                DFS(integer);
            }

        }

        public static void BFS(int node){
            visited[node] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()){
                int poll = queue.poll();

                for (Integer integer : map[poll]) { // 연결노드들 찾기
                    if (visited[integer]) continue;
                    visited[integer] = true;
                    queue.add(integer);
                }

            }
        }
    }

    public class BOJ18406 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String n = sc.nextLine();
            int length = n.length();
            int sumLeft = 0;
            int sumRight = 0;

            for (int i = 0; i < length / 2; i++) {
                sumLeft += n.charAt(i) - '0';
            }

            for (int i = length / 2; i < length; i++) {
                sumRight += n.charAt(i) - '0';
            }

            if (sumLeft == sumRight) {
                System.out.println("LUCKY");
            } else {
                System.out.println("READY");
            }
        }
    }



}
