import java.util.*;

public class Sol325Kakao {
    // N은 스테이지 총 개수, stages 는 각각 사용자가 머물러있는 스테이지의 번호
    // 스테이지 내에서 같은 숫자를 찾아서, 같숫/n 을 쳐서, 실패율 순으로 리턴하면 된다.
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();
        int total = stages.length;

        // 각 스테이지별 도전중인 사용자 수 카운트
        int[] cnt = new int[N+1];
        for (int i : stages) {
            if (i <= N) cnt[i]++;
        }

        // 각 스테이지별 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (total == 0 || cnt[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) cnt[i] / total);
                total -= cnt[i];
            }
        }

        // 실패율을 내림차순으로 정렬하여 스테이지 번호만 추출
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            double v1 = map.get(o1);
            double v2 = map.get(o2);
            if (v1 == v2) {
                return o1 - o2;
            } else {
                return Double.compare(v2, v1);
            }
        });

        // 배열에 담아서 반환
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
