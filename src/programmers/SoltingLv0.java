package programmers;

import java.util.Comparator;

public class SoltingLv0 {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] result = new int[n];
        if (direction.equals("right")) {
            for (int i = 0; i < n; i++) {
                result[(i + 1) % n] = numbers[i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = numbers[(i + 1) % n];
            }
        }
        return result;
    }
}
