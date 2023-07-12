package programmers;

import java.util.*;

public class SOL0712 {
    static class doublePriority {
        public int[] solution(String[] operations) {
            int[] answer = {0, 0};

            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

            for (String operation : operations) {
                StringTokenizer st = new StringTokenizer(operation);

                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    minQ.add(value);
                    maxQ.add(value);
                } else {
                    if (!minQ.isEmpty()) {
                        if (value == 1) {
                            int max = maxQ.poll();
                            minQ.remove(max);
                        } else {
                            int min = minQ.poll();
                            maxQ.remove(min);
                        }
                    }
                }
            }

            if (!minQ.isEmpty()) {
                answer[0] = maxQ.peek();
                answer[1] = minQ.peek();
            }

            return answer;
        }
    }

    static class makeMaxArr{
        public int[] solution(int n, int s) { // n 은 배열의 크기, s 배열 값들의 총합
            int[] answer = new int[n];

            if (n > s) {
                return new int[]{-1};
            }


            if (s % n == 0){
                Arrays.fill(answer, s / n);
            } else {
                Arrays.fill(answer, s / n);
                for (int i = 0; i < s % n; i++) {
                    answer[n - 1 - i] ++; // 마지막부터 하나씩 ++
                }
            }

            return answer;
        }
    }
}
