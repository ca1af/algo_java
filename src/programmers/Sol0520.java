package programmers;

import java.util.*;

public class Sol0520 {
    //[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
    //https://school.programmers.co.kr/learn/courses/30/lessons/42584
    public int[] solution0(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }

        answer[prices.length - 1] = 0;

        while (!queue.isEmpty()) {
            if (queue.peek() == null) {
                break;
            }
            Integer poll = queue.poll();
            Integer peeked = queue.peek();
            while (poll > peeked) {
                Integer poll2 = queue.poll();
                Integer peek2 = queue.peek();
            }
        }

        return answer;
    }

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution0(int k, int m, int[] score) {
        // k 는 최고점수, m은 개수, score 는 점수 분포 배열

        Arrays.sort(score);

        Stack<Integer> stack = new Stack<>();

        for (int i : score) {
            stack.push(i);
        }

        int[][] arr = new int[score.length / m][m];

        for (int i = 0; i < score.length / m; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = stack.pop();
            }
        }

        int sum = 0;

        for (int[] ints : arr) {
            int i = Arrays.stream(ints).min().orElseThrow();
            sum += i * m;
        }

        return sum;
    }

    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int groupCount = score.length / m;
        int sum = 0;

        for (int i = 0; i < groupCount; i++) {
            int minScore = score[i * m];
            sum += minScore * m;
        }

        return sum;
    }

    //입출력 예제
    //예제	dartResult	answer	설명
    //1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
    //2	1D2S#10S	9	12 + 21 * (-1) + 101
    //3	1D2S0T	3	12 + 21 + 03
    //4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
    //5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
    //6	1T2D3D#	-4	13 + 22 + 32 * (-1)
    //7	1D2S3T*	59	12 + 21 * 2 + 33 * 2

    //https://school.programmers.co.kr/learn/courses/30/lessons/17682

    public int solution0(String dartResult) {
        char[] charArray = dartResult.toCharArray();

        Queue<Character> queue = new LinkedList<>();

        for (char c : charArray) {
            queue.add(c);
        }

        int sum = 0;



        while (!queue.isEmpty()){
            Character polled = queue.poll();

            if (Character.isDigit(polled)){
                Character func1 = queue.poll();

                int parseInt = Integer.parseInt(String.valueOf(polled));

                if (func1.equals('D')){
                    sum += parseInt * parseInt;
                } else if (func1.equals('T')){
                    sum += parseInt * parseInt * parseInt;
                }

                if (queue.peek() != null && !Character.isDigit(queue.peek())){
                    if (queue.poll().equals('*')){
                        sum *= 2;
                    } else {
                        sum *= -1;
                    }
                }


            }


        }

        return sum;
    }

    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                idx++;
                if (c == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    scores[idx] = 10;
                    i++;
                } else {
                    scores[idx] = Character.getNumericValue(c);
                }
            } else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'D') {
                    scores[idx] *= scores[idx];
                } else if (c == 'T') {
                    scores[idx] *= scores[idx] * scores[idx];
                }
            } else if (c == '*' || c == '#') {
                if (c == '*') {
                    if (idx > 0) {
                        scores[idx - 1] *= 2;
                    }
                    scores[idx] *= 2;
                } else if (c == '#') {
                    scores[idx] *= -1;
                }
            }
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        return sum;
    }



}
