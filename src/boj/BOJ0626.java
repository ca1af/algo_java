package boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ0626 {
    public static class BOJ2163 {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(N * M - 1);
        }
    }
    public static class BOJ26215{
        public static void main(String[] args) {
            // priority queue 사용해서 두개 꺼낸 후 둘다 1보다 크면 각각 1 감소시켜서 다시 꾸겨넣기
            // 계속 반복, 두개 중 하나라도 0이라면 0이 아닌놈만큼 답에 ++

            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            while(!pq.isEmpty()){
                Integer poll = pq.poll();
                Integer poll1 = pq.poll();

                if (poll1 == 0 || poll == 0){
                    answer += poll1 += poll; // 어챂 둘중하나는 0임
                    break;
                }

            }
        }
    }
}
