import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Collatz {
    //스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다
    //최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

    public String[] solution(String[] orders, int[] course) {

        // 즉, orders 에서 가장 많이 겹치는 메뉴로, course 에 담으라는 뜻.

        char[] chars;
        chars = new char[]{'A','B','C','D','E','F','G','H','I','J'};

        Map<Character, Integer> map = new HashMap();
        for (char aChar : chars) {
            map.put(aChar, 0);
        }

        for (String order : orders) {
            for (char c : order.toCharArray()) {
                Integer integer = map.get(c);
                map.put(c, integer + 1);
            }
        }


        String[] answer = {};
        return answer;
    }
}
