import java.util.Arrays;

public class Sol0406 {
    public int solution(int[] people, int limit) {
        // 사람들의 몸무게를 오름차순으로 정렬합니다.
        Arrays.sort(people);

        int answer = 0; // 필요한 구명보트 개수를 저장할 변수
        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스

        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람이 같이 탈 수 있는 경우
            if (people[left] + people[right] <= limit) {
                left++; // 가장 가벼운 사람은 탈출했으므로 다음으로 넘어갑니다.
            }
            right--; // 가장 무거운 사람은 항상 탈출하므로 다음으로 넘어갑니다.
            answer++; // 구명보트 하나를 사용했으므로 개수를 증가시킵니다.
        }

        return answer;
    }
}
