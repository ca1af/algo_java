import java.util.*;

public class adad {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine); // 귤의 크기를 오름차순으로 정렬
        Set<Integer> set = new HashSet<>(); // 중복되지 않는 귤의 크기를 저장할 Set

        // 크기가 가장 작은 k개의 귤을 선택
        for (int i = 0; i < k; i++) {
            set.add(tangerine[i]); // Set에 추가
        }

        return set.size(); // 종류의 수 반환
    }
}
