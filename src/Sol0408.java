import java.util.*;

public class Sol0408 {
    public int solution2(int k, int d) {
        int count = 0;

        // x축 방향으로 a*k만큼, y축 방향으로 b*k만큼 떨어진 위치
        for (int a = 0; a*k <= d; a++) {
            for (int b = 0; b*k <= d; b++) {
                if (Math.sqrt(Math.pow(a*k, 2) + Math.pow(b*k, 2)) <= d) {
                    count++;
                }
            }
        }

        return count;
    }
    // 시간초과떴음
    public String solution(String number, int k) {
        List<String> sb = new ArrayList<>();

        for (int i = 0; i < number.length()-k; i++) {
            sb.add(number.substring(i, i+k));
        }
        System.out.println(sb);

        String answer = "";
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12934

    public long solution(long n) {
        double sqrt = Math.sqrt(n);

        long round = Math.round(sqrt);

        if (n == round * round){
            return (long) Math.pow(round +1, 2);
        }
        else return -1L;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/77884

    public int solution(int left, int right) {
        int count = 0;
        int answer = 0;

        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= right; j++) {
                if (i % j == 0){
                    count++;
                }
            }
            if (count % 2 == 0){
                answer += i;
            } else answer -= i;

            count = 0;
        }

        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/147355

    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (Integer.parseInt(t.substring(i, p.length() + i)) <= Integer.parseInt(p)) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(String t, String p) {
        int answer = 0;
        long pValue = Long.parseLong(p);
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String subString = t.substring(i, p.length() + i);
            if (Long.parseLong(subString) < pValue) {
                answer++;
            }
        }
        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=java

    public Object[] solution1(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new TreeSet<>();

        for (int number : numbers) {
            for (int i : numbers) {
                set.add(number + i);
            }
        }

        Object[] objects = set.toArray();

        return objects;
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            answer[idx++] = num;
        }

        return answer;
    }
}
