import java.util.*;

public class Sol0513 {
    public int solution0(int[] numbers, int target) {
        int sum = 0;

        int answer = 0;
        return answer;
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        return answer;
    }

    public int solution0(int n, int a, int b) {
        int count = 0;

        while (n < 1) {
            if (Math.abs(a - b) == 1) {
                count++;
                return count;
            }
            n = n / 2;

            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = a / 2 + 1;
            }

            if (b % 2 == 0) {
                b = b / 2;
            } else {
                b = b / 2 + 1;
            }

            count++;
        }
        return count;
    }

    public int solution(int n, int a, int b) {
        int count = 0;

        while (n > 1) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            count++;

            if (a == b) {
                return count;
            }

            n /= 2;
        }

        return count;
    }

    public int solution(int n) {
        int count = 0;

        while (n <= 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                count++;
            }
        }

        return count;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int[] answer = {};

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int progress : progresses) {
            queue.add(progress);
        }



        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll < 100) {
                poll += speeds[day];
            } else {
                day++;
            }

        }
        return answer;
    }

    public int solution0(String num_str) {
        int answer = 0;
        char[] chars = num_str.toCharArray();
        for (char a : chars){
            int b = Integer.parseInt(String.valueOf(a));
            answer += b;
        }
        return answer;

    }

    public String[] solution(String my_string) {
        String[] answer = {};
        String[] s = my_string.split(" ");
        return answer;
    }

}
