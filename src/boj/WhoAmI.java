package boj;

import java.util.*;

public class WhoAmI {

    class Solution1 {
        public int solution(String s, int N) {
            int answer = -1; // 없으면 그대로 반환

            for (int i = 0; i <= s.length() - N; i++) {
                String substring = s.substring(i, i + N);
                if (isPandigital(substring)) {
                    int substringNum = Integer.parseInt(substring);
                    if (substringNum > answer) {
                        answer = substringNum; // 더 큰수면 재할당
                    }
                }
            }
            return answer;
        }

        public static boolean isPandigital(String substring) {
            char[] digits = substring.toCharArray();
            Arrays.sort(digits); // 오름차순 정렬
            String sortedNumber = new String(digits); // 정렬된놈으로 새 스트링

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= digits.length; i++) {
                sb.append(i);
            }
            return sortedNumber.contentEquals(sb);
        }
    }

    class Solution2 {
        public int solution(int[][] relationships, int target, int limit) {
            Map<Integer, List<Integer>> graph = buildGraph(relationships);

            int originalFriends = getOriginalFriends(graph, target);
            int newFriends = getNewFriends(graph, target, limit);

            int reward = originalFriends * 5 + newFriends * 10;
            return reward;
        }

        private Map<Integer, List<Integer>> buildGraph(int[][] relationships) {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] relationship : relationships) {
                int person1 = relationship[0];
                int person2 = relationship[1];

                // person1과 person2를 친구로 추가
                graph.putIfAbsent(person1, new ArrayList<>());
                graph.putIfAbsent(person2, new ArrayList<>());
                graph.get(person1).add(person2);
                graph.get(person2).add(person1);
            }

            return graph;
        }

        private static int getOriginalFriends(Map<Integer, List<Integer>> graph, int target) {
            int originalFriends = 0;

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[101];

            // target을 큐에 추가하고 방문 표시
            queue.offer(target);
            visited[target] = true;

            while (!queue.isEmpty()) {
                int person = queue.poll();

                // target과 친구인 사람들을 탐색
                List<Integer> friends = graph.get(person);
                for (int friend : friends) {
                    if (!visited[friend]) {
                        queue.offer(friend);
                        visited[friend] = true;
                        originalFriends++;
                    }
                }
            }

            return originalFriends;
        }

        private static int getNewFriends(Map<Integer, List<Integer>> graph, int target, int limit) {
            int newFriends = 0;

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[101];

            // target을 큐에 추가하고 방문 표시
            queue.offer(target);
            visited[target] = true;

            int level = 1;
            while (!queue.isEmpty() && level <= limit) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int person = queue.poll();

                    // target과 친구인 사람들을 탐색
                    List<Integer> friends = graph.get(person);
                    for (int friend : friends) {
                        if (!visited[friend]) {
                            queue.offer(friend);
                            visited[friend] = true;
                            newFriends++;
                        }
                    }
                }

                level++;
            }

            return newFriends;
        }
    }

    class Sol3 {
        static char[] chars = {'&', ',', '.', '-', '(', ')'};
        public String[] solution(String[] merchantNames) {
            String[] answer = {};
            // merchantNames 포문돌면서 배열의 요소 첫글자를 맵에 넣는다
            // 특수 문자를 갖고있는 char 배열을 만들어서, contains 함수를 통해서 merchantNames 의 요소들이 특수문자를 포함하면, map에서 같은 녀석은 돌지 않는다.
            // 다른 녀석이 등장하면, 맵에 새 요소를 넣고 돌린다.

            HashMap<String, Integer> hashMap = new HashMap(); // key 와 렝스를 넣을 녀석.

            // 경우를 생각해보자
            // 공백이 있어서 stringTokenizer 로 나눌 수 있을 경우, 앞 녀석이 무조건 그거임

            StringTokenizer st;

            for (String merchantName : merchantNames) {
                String s;
                if (isContain(merchantName) != '?'){ // ?가 아니라서 실제 특수문자면
                    s = merchantName.substring(0,merchantName.indexOf(isContain(merchantName))); // 특수문자가 있는 녀석 기준으로 섭스트링
                } else {
                    s = merchantName.substring(0, merchantName.indexOf(" "));
                }

                if (hashMap.containsKey(merchantName) && hashMap.get(s) < merchantNames.length){
                    hashMap.put(s, merchantNames.length); //
                } else if (hashMap.isEmpty()){ // 비어있으면 넣어준다.
                    hashMap.put(s, merchantNames.length);
                }
            }

            return answer;
        }

        private static Character isContain(String s){
            ArrayList<Character> ts = new ArrayList<>();
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                ts.add(charArray[i]);
            }

            for (int i = 0; i < chars.length; i++) {
                if (ts.contains(chars[i])) return chars[i];
            }
            return '?';
        }
    }
}
