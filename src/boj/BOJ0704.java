package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ0704 {
    public static class BOJ1021 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주어지는 큐의 크기 1~N
            int M = Integer.parseInt(st.nextToken()); // 주어질 수 M개

            int[] given = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                given[i] = Integer.parseInt(st.nextToken());
            }

            LinkedList<Integer> deque = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                deque.add(i); // deque 초기화
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                int target_idx = deque.indexOf(given[i]);
                int half_idx;
                if (deque.size() % 2 == 0) {
                    half_idx = deque.size() / 2 - 1;
                } else {
                    half_idx = deque.size() / 2;
                }


                // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
                if (target_idx <= half_idx) {
                    for (int j = 0; j < target_idx; j++) {
                        int temp = deque.pollFirst();
                        deque.offerLast(temp);
                        count++;
                    }
                } else {    // 중간 지점보다 원소의 위치가 뒤에 있는 경우
                    for (int j = 0; j < deque.size() - target_idx; j++) {
                        int temp = deque.pollLast();
                        deque.offerFirst(temp);
                        count++;
                    }
                }
                deque.pollFirst();    // 연산이 끝나면 맨 앞 원소를 삭제
            }
            System.out.println(count);
        }
    }
}

