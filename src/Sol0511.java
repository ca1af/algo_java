import java.util.*;

public class Sol0511 {
    // 스코빌 지수 주어지면 최소 + 최소+1 *2 해서 전체 배열을 모두 스코빌보다 더 높게 하기.
    public int solution1(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
        int answer = 0;

        for (int i : scoville) {
            pq.add(i);
        }

        for (Integer integer : pq) {
            if (integer < K){
                Integer integer1 = pq.poll();
                Integer integer2 = pq.poll();

                pq.add(integer1 + integer2 * 2);

                answer++;
            }
        }

        return answer;
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
        int answer = 0;

        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.peek() < K){
            if (pq.size() == 1){
                return -1;
            }

            int min1 = pq.poll();
            int min2 = pq.poll();

            int newInt = min1 + min2 *2;
            pq.add(newInt);
            answer++;
        }

        return answer;
    }

    public int solution(String before, String after) {
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 1;

        for (char c : before.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : after.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (Character character : map.keySet()) {
            if (!Objects.equals(map.get(character), map2.get(character))){
                answer = 0;
            }
        }

        return answer;
    }

    //문제 설명
    //정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

    public int solution0(int[] array, int n) {
        int answer = array[0];
        int minDiff = Math.abs(n - array[0]);

        for (int i = 1; i < array.length; i++) {
            int diff = Math.abs(n - array[i]);
            if (diff < minDiff) {
                minDiff = diff;
                answer = array[i];
            }
        }

        return answer;
    }

    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < emergency.length; i++) {
            map.put(i + 1, emergency[i]);
        }

        Arrays.sort(emergency);

        for (int i = 0; i < emergency.length; i++) {
            answer[i] = map.get(i+1);
        }

        return answer;
    }

    public String solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (Character character : map.keySet()) {
            if (map.get(character) == 1){
                sb.append(character);
            }
        }

        char[] charArray = sb.toString().toCharArray();
        Arrays.sort(charArray);

        return new String(charArray);
    }
}
