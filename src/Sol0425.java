import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Sol0425 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        // 참여자 명단을 map에 넣고, 동명이인인 경우 값을 증가시킴
        for (String s : participant) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        // 완주자 명단을 순회하면서 해당 키의 값을 감소시킴
        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            }
        }

        // 값이 0인 키를 찾아서 반환
        for (String key : map.keySet()) {
            if (map.get(key) == 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/42578

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (!map.containsKey(clothe[1])){
                map.put(clothe[1], 1);
            } else {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            }
        }

        int sum = 0;
        int multiple = 1;

        for (String s : map.keySet()) {
            sum += map.get(s);
            if (map.size() != 1){
                multiple *= map.get(s);
            } else {
                multiple = 0;
            }
        }


        int answer = sum + multiple;
        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/42587

    //예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고,
    // 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
    public int solution(int[] priorities, int location) {
        // 1. 큐에 넣는다.
        // 2. 배열의 맥스값부터 시작한다. i 는 순서대로 찾아서, i==max 라면 실행하고, 그 후 다시 max를 갱신한다.

        // 인덱스를 맞추는게 중헌디...예를 들어 [2,1,3,2] 라고 하면?
        // 맥스인덱스부터 시작하자구. 3,2 그대로 하고, 다시 돌아와서 첫번째부터 탐색하게 할 방법?

        Queue<Integer> queue = new LinkedList<>();



        int answer = 0;
        return answer;
    }
}
