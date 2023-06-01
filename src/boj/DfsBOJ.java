package boj;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DfsBOJ{
    public class BOJ11724{
        static boolean[] visited;
        static ArrayList<Integer>[] A;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 노드 개수
            int m = Integer.parseInt(st.nextToken()); // 엣지 개수

            visited = new boolean[n + 1]; // 0번 인덱스 사용하면 헷갈리니까 걍 N+1 선언

            A = new ArrayList[n+1];

            for (int i = 1; i < A.length; i++) {
                A[i] = new ArrayList<>(); // 실제 객체 선언
            }

            for (int i = 0; i < m; i++) { // 엣지 개수만큼 (== 주어지는 엣지 정보 담기 위해)
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end); //  시작점에서 종료점으로 갈 수 있다
                A[end].add(start); // 종료점에서 시작점으로 갈 수 있다.
            }

            int count = 0;

            for (int i = 1; i < n + 1; i++) { // 1~n+1 이 어레이리스트의 유효지점이기 때문에 맞춰준다
                if (!visited[i]){ // 방문하지 않은 노드가 있으면
                    count++;
                    dfs(i); // 방문하지 않은 해당 노드 기준으로 dfs 실행!
                }
            }
            System.out.println(count);
        }

        private static void dfs(int node) {
            if (visited[node]){ // 현재 노드가 이미 방문한 노드라면
                return;
            }
            visited[node] = true; // 방문하지 않았으면, 방문으로 만들고
            for (Integer integer : A[node]) { // 현재 노드에서 연결되어 있는 노드 모두 돌면서
                if (!visited[integer]){ // 인접리스트 안에 있는 요소가 아직 탐색되지 않은 노드라면
                    dfs(integer); // 탐색하지 않은 노드 기준으로 다시 dfs 실행해라!
                }
            }
        }
    }

//    public static class BOJ24479 {
//        static int[] visited;
//        static ArrayList<Integer>[] lists;
//        static int count;
//
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            int N = Integer.parseInt(st.nextToken()); // node
//            int E = Integer.parseInt(st.nextToken()); // edge
//            int R = Integer.parseInt(st.nextToken()); // starting point
//
//            visited = new int[N + 1]; // 노드 방문 했는지?
//            Arrays.fill(visited, 0); // 미방문으로 초기화
//
//            lists = new ArrayList[N + 1];
//
//            for (int i = 1; i < E + 1; i++) {
//                lists[i] = new ArrayList<>();
//
//                st = new StringTokenizer(br.readLine());
//                int start = Integer.parseInt(st.nextToken()); // 주어지는 간선 (x, )
//                int end = Integer.parseInt(st.nextToken()); // 주어지는 간선 ( ,y)
//
//                lists[start].add(end); // 새 배열에 그냥 넣고 시작, 시작에 끝넣고
//                lists[end].add(start); // 끝에 시작 넣고 (양방향이므로)
//            }
//
//            for (ArrayList<Integer> list : lists) {
//                Collections.sort(list); // 오름차순으로 정렬 (문제 요구사항)
//            }
//
//            count = 1;
//
//            dfs(R);
//
//            StringBuilder sb = new StringBuilder();
//
//            for (int i : visited) {
//                sb.append(i).append("\n");
//            }
//
//            System.out.println(sb.toString());
//        }
//
//        static void dfs(int node){
//            visited[node] = count;
//
//            for (int i = 0; i < lists.length; i++) {
//                Integer integer = lists[node].get(i);
//
//                if (visited[integer] == 0){
//                    count++;
//                    dfs(integer);
//                }
//            }
//        }
//
//
//    }


    public static class BOJ24479_answer {
        int[] answer;
        ArrayList<Integer>[] edges;
        int idx = 0;
        boolean[] v;

        private void dfs(int cur) {
            answer[cur] = ++idx;
            for (int next : edges[cur]) {
                if (v[next]) continue;
                v[next] = true;
                dfs(next);
            }
        }

        private void solution() throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            edges = new ArrayList[n+1];

            for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

            answer = new int[n+1];

            v = new boolean[n+1];

            while (m-->0) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                edges[u].add(v);
                edges[v].add(u);
            }

            for (int i = 1; i <= n; i++) Collections.sort(edges[i]);

            v[r] = true;

            dfs(r);

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) sb.append(answer[i]).append('\n');

            System.out.print(sb);
        }

        public static void main(String[] args) throws Exception {
            new BOJ24479_answer().solution();
        }
    }


    public static class BOJ24479_FAIL {
        static int[] answer;
        static ArrayList<Integer>[] edges;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // node 수
            int M = Integer.parseInt(st.nextToken()); // edge
            int R = Integer.parseInt(st.nextToken()); // starting point

            edges = new ArrayList[N + 1]; // "배열" 에 대한 초기화 (배열 길이 명시, 인스턴스 선언)

            answer = new int[N + 1]; // 정답 배열,
            Arrays.fill(answer, 0); // 0으로 초기화 (들리지 않은 상태임을 나타냄)

            for (int i = 1; i < N + 1; i++) {
                edges[i] = new ArrayList<>(); // 각각 어레이리스트 초기화
            }

            for (int i = 0; i < M; i++) { // M개만큼 엣지 정보 주어지므로 받자
                st = new StringTokenizer(br.readLine());
                //입력 예시
                //1 4
                //1 2
                //2 3
                //2 4
                //3 4

                int start = Integer.parseInt(st.nextToken()); // 1
                int end =  Integer.parseInt(st.nextToken()); // 4

                edges[start].add(end); // edges[1].add(4) -> edges[1] = {4, 2}...
                edges[end].add(start); // edges[4].add(1) -> edges[4] = {1, 2, 3}...
            }

            for (int i = 1; i < edges.length; i++) {
                Collections.sort(edges[i]);
            }

            int count = 1;

            // 이제, DFS를 통해서 스타트지점에서 끝지점까지 찍어보고 아닌놈 출력해야함
            dfs(R, count); // starting point 는 R이다.

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < answer.length; i++) {
                sb.append(answer[i]).append("\n");
            }

            System.out.println(sb.toString());
        }

        public static void dfs(int node, int count){ // answer[node] += count++; 이게 맞는데? 첫번째놈부터 돌리는
            answer[node] = count; // 들렀다는 표시
            for (Integer integer : edges[node]) { // 예를들어 r = 1 이어서 1로 들어왔다면, 1번과 붙어있는 모든 놈들 반복하면서
                if (answer[integer] == 0) { // 예를 들어 1과 연결된 2(==integer) 가 아직 안들렀다면,
                    dfs(integer, count + 1); // 들르러 가. 가면 2번도 바로 활성화된다.
                }
            }
        }
    }

// 오름차순
    public class BOJ24479 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static StringBuilder sb = new StringBuilder();

        static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
        static int[] check; // 방문한 정점을 기록할 배열
        static int count; // 방문 순서

        public static void main(String[] args) throws IOException {

            st = new StringTokenizer(br.readLine());

            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int startVertex = Integer.parseInt(st.nextToken());

            // 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
            // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
            check = new int[vertex+1];

            // graph의 index를 정점의 개수만큼 만들어줌
            for(int i =0; i < vertex+1; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());
                int fromVertex = Integer.parseInt(st.nextToken());
                int toVertex = Integer.parseInt(st.nextToken());

                // 무방향이기 때문에 양쪽으로 정보를 추가
                graph.get(fromVertex).add(toVertex);
                graph.get(toVertex).add(fromVertex);
            }

            // 오름차순을 위해 정렬
            for(int i = 1; i < graph.size(); i++) {
                Collections.sort(graph.get(i));
            }

            // 시작 정점도 순서에 포함이므로 count 초기값 1 할당
            count = 1;

            // 깊이 우선 탐색 재귀 시작
            dfs(startVertex);

            // 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
            for(int i = 1; i < check.length; i++) {
                sb.append(check[i]).append("\n");
            }
            System.out.println(sb);
        }

        // 깊이 우선 탐색 메서드
        private static void dfs(int vertex) {
            check[vertex] = count; // 현재 방문하고있는 정점에 순서 저장

            // 현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
            for(int i = 0; i < graph.get(vertex).size(); i++) {
                int newVertex = graph.get(vertex).get(i);

                //다음 갈 정점을 방문했었는지 체크(0일 경우 방문 X)
                if(check[newVertex] == 0){
                    count++;
                    dfs(newVertex);
                }
            }
        }
    }

    // 내림차순
    public class BOJ24480 {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static StringBuilder sb = new StringBuilder();

        static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
        static int[] check; // 방문한 정점을 기록할 배열
        static int count; // 방문 순서

        public static void main(String[] args) throws IOException {

            st = new StringTokenizer(br.readLine());

            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int startVertex = Integer.parseInt(st.nextToken());

            // 방문한 정점이 최대 정점의 개수만큼 있기 때문에, 정점의 개수만큼의 크기로 배열 생성
            // index 혼란을 방지하고자 0번 인덱스를 더미 데이터로 활용
            check = new int[vertex+1];

            // graph의 index를 정점의 개수만큼 만들어줌
            for(int i =0; i < vertex+1; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < edge; i++) {
                st = new StringTokenizer(br.readLine());
                int fromVertex = Integer.parseInt(st.nextToken());
                int toVertex = Integer.parseInt(st.nextToken());

                // 무방향이기 때문에 양쪽으로 정보를 추가
                graph.get(fromVertex).add(toVertex);
                graph.get(toVertex).add(fromVertex);
            }

            // 오름차순을 위해 정렬
            for(int i = 1; i < graph.size(); i++) {
                graph.get(i).sort(Collections.reverseOrder());
            }

            // 시작 정점도 순서에 포함이므로 count 초기값 1 할당
            count = 1;

            // 깊이 우선 탐색 재귀 시작
            dfs(startVertex);

            // 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
            for(int i = 1; i < check.length; i++) {
                sb.append(check[i]).append("\n");
            }
            System.out.println(sb);
        }

        // 깊이 우선 탐색 메서드
        private static void dfs(int vertex) {
            check[vertex] = count; // 현재 방문하고있는 정점에 순서 저장

            // 현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
            for(int i = 0; i < graph.get(vertex).size(); i++) {
                int newVertex = graph.get(vertex).get(i);

                //다음 갈 정점을 방문했었는지 체크(0일 경우 방문 X)
                if(check[newVertex] == 0){
                    count++;
                    dfs(newVertex);
                }
            }
        }
    }


}
