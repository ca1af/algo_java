import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SOls {
    public static int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }
        Map<?,?> d = new HashMap<>();

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int[] result = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex) {
                result[j] = arr[i];
                j++;
            }
        }

        return result;
    }

    boolean solution(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '('){
                count++;
            } else {
                count--;
                if (count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}
