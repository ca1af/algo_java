import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ad {
    public int solution(int[] array, int n) {
        int answer = 0;
        int max = -1;
        for (int j : array) {
            if (Math.abs(n-j) > max){
                max = Math.abs(n-j);
                answer = j;
            }
        }
        return answer;
    }
}
