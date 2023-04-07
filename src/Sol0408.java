import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        int answer = 0;
        return answer;
    }
}
