package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ0708 {
    private static class BOJ24444 {
        static boolean visited[];
        static int N;
        static ArrayList<Integer>[] edges;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 노드의 갯수
            int M = Integer.parseInt(st.nextToken()); // 엣지의 갯수
            int startNode = Integer.parseInt(st.nextToken()); // 시작 노드

            visited = new boolean[N + 1]; // 방문여부 배열 초기화
            Arrays.fill(visited, false);
            visited[0] = false;
            edges = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>(); // 간선 입력받기 위한 어레이리스트 초기화
            }

            for (int i = 0; i < M; i++) { // 엣지 다 입력받기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edges[start].add(end); // 양방향 추가
                edges[end].add(start); // 양방향 추가
            }

            for (int i = 1; i <= N; i++) {
                Collections.sort(edges[i]); // 오름차순 정렬
            }

            bfs(startNode);
        }

        private static void bfs(int node) {
            Queue<Integer> queue = new LinkedList<>();
            int[] answer = new int[N + 1];
            int count = 0;
            Arrays.fill(answer, 0);
            queue.add(node);
            visited[node] = true;
            answer[node] = ++count;

            while (!queue.isEmpty()){
                Integer givenNode = queue.poll();

                for (Integer integer : edges[givenNode]) {
                    if (!visited[integer]){
                        visited[integer] = true;
                        queue.add(integer);
                        answer[integer] = ++count;
                    }
                }
            }

            for (int i = 1; i < answer.length; i++) {
                System.out.println(answer[i]);
            }
        }
    }


    private static class BOJ24444_2 {
        static boolean visited[];
        static ArrayList<Integer>[] edges;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 노드의 갯수
            int M = Integer.parseInt(st.nextToken()); // 엣지의 갯수
            int startNode = Integer.parseInt(st.nextToken()); // 시작 노드

            visited = new boolean[N + 1]; // 방문여부 배열 초기화
            Arrays.fill(visited, false);
            edges = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                edges[i] = new ArrayList<>(); // 간선 입력받기 위한 어레이리스트 초기화
            }

            for (int i = 0; i < M; i++) { // 엣지 다 입력받기
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edges[start].add(end); // 양방향 추가
                edges[end].add(start); // 양방향 추가
            }

            for (int i = 1; i <= N; i++) {
                Collections.sort(edges[i]); // 오름차순 정렬
            }

            bfs(startNode);
        }

        private static void bfs(int node) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            visited[node] = true;

            while (!queue.isEmpty()) {
                Integer givenNode = queue.poll();
                System.out.println(givenNode);

                for (Integer integer : edges[givenNode]) {
                    if (!visited[integer]) {
                        visited[integer] = true;
                        queue.add(integer);
                    }
                }
            }
        }
    }

}
