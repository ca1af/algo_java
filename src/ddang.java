import java.util.Arrays;

public class ddang {
    // 이중배열 land 가 주어진다
    // 
    int solution(int[][] land) {
        int answer = 0;
        for (int[] ints : land) {
            Arrays.stream(ints).min();
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
