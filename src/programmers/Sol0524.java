package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sol0524 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }

        int count = 1;
        int prev = queue.poll();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (prev >= current) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                prev = current;
            }
        }

        answerList.add(count);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
