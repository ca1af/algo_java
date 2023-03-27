import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rottry {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;

        for (int k : lottos) {
            if (k == 0) {
                zeroCount++;
            }
        }

        for (int lotto : lottos) {
            for (int winNum : win_nums) {
                if (lotto == winNum) {
                    matchCount++;
                    break;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = getRank(matchCount + zeroCount);
        answer[1] = getRank(matchCount);

        return answer;
    }

    private int getRank(int matchCount) {
        return switch (matchCount) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
