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

        public static void dfs(int node){
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

        public static void bfs(int node){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node); // 첫 노드 큐에 저장.
            visited[node] += count;

            while (!queue.isEmpty()){
                int poll = queue.poll();
                for (Integer integer : edges[poll]) {
                    if (visited[integer] == 0){
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

            for (int i = 2; i <= Math.sqrt(N); i++){
                if (arr[i] == 0) continue;
                for (int j = i + i; j <= N; j = i + j){
                    arr[j] = 0;
                }
            }

            for (int i = M; i <= N; i++){
                if (arr[i] != 0){
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
