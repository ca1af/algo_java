package programmers;

import java.util.*;

public class Sol0522 {
    // players 중에서 이름 불린 녀석은 인덱스가 +1됨.
    public String[] solution0(String[] players, String[] callings) {

        int temp = 0;

        //["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"] ["mumu", "kai", "mine", "soe", "poe"]

        for (int i = 0; i < callings.length; i++) {
            int j = callings[i].indexOf(Arrays.toString(players));
            String calledPlayer = players[j];
            String previousPlayer = players[j - 1];

            players[j] = previousPlayer;
            players[j-1] = calledPlayer;
        }

        return players;
    }

    public String[] solution2(String[] players, String[] callings) {

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];
            int j = Arrays.asList(players).indexOf(calling);
            if (j > 0) {
                String calledPlayer = players[j];
                String previousPlayer = players[j - 1];

                players[j] = previousPlayer;
                players[j - 1] = calledPlayer;
            }
        }

        return players;
    }

    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        ArrayList<String> playerList = new ArrayList<>(Arrays.asList(players));

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];
            if (playerMap.containsKey(calling)) {
                int j = playerMap.get(calling);
                if (j > 0) {
                    String calledPlayer = playerList.get(j);
                    String previousPlayer = playerList.get(j - 1);

                    playerList.set(j, previousPlayer);
                    playerList.set(j - 1, calledPlayer);

                    playerMap.put(previousPlayer, j);
                    playerMap.put(calledPlayer, j - 1);
                }
            }
        }

        return playerList.toArray(new String[0]);
    }

    public String solution0(String X, String Y) {
        // X와 Y에서 겹치는 수를 찾아내서(중복 허용) 그걸로 만들 수 있는 가장 큰 수 리턴, 없으면 -1
        //  "5525"	"1255"	"552"

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (char c : X.toCharArray()) {
            hashMap.put(Character.getNumericValue(c), hashMap.getOrDefault(Character.getNumericValue(c), 0) + 1);
        }

        HashMap<Integer, Integer> duplicatedMap = new HashMap<>();

        for (char c : Y.toCharArray()) {
            if (hashMap.containsKey(Character.getNumericValue(c))){
                duplicatedMap.put(Character.getNumericValue(c), hashMap.getOrDefault(Character.getNumericValue(c), 0) + 1);
            }
        }
        
        List<Integer> arr = new ArrayList<>();

        for (Integer integer : duplicatedMap.keySet()) {
            duplicatedMap.get(integer);
            arr.add(integer);
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        StringBuilder sb = new StringBuilder();

        for (Integer integer : arr) {
            sb.append(integer);
        }

        return duplicatedMap.size() == 0 ? "-1" : sb.toString();
    }

    public String solution(String X, String Y) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : X.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (char c : Y.toCharArray()) {
            if (countMap.containsKey(c) && countMap.get(c) > 0) {
                result.append(c);
                countMap.put(c, countMap.get(c) - 1);
            }
        }

        char[] charArray = result.toString().toCharArray();

        Arrays.sort(charArray);

        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
        }

        String answer = new String(charArray);

        if (charArray.length == 0){
            return "-1";
        }
        int parseInt = Integer.parseInt(answer);

        return String.valueOf(parseInt);
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/136798

    public int solutionTimeOut(int number, int limit, int power) {
        // number 까지 숫자들의 약수 집합을 구해서, 배열로 만든다.
        // 약수 집합 배열을 반복문으로 탐색하면서 limit 보다 큰 녀석은 power 로 재할당한다.

        int[] weapons = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            int temp = 0;
            for (int j = 1; j <= i ; j++) {
                if (i % j == 0){
                    temp++;
                }
            }

            weapons[i] = temp;
            temp = 0;
        }

        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] > limit){
                weapons[i] = power;
            }
        }

        int answer = 0;

        for (int weapon : weapons) {
            answer += weapon;
        }

        return answer;
    }

    public int solution(int number, int limit, int power) {
        // number 까지 숫자들의 약수 집합을 구해서, 배열로 만든다.
        // 약수 집합 배열을 반복문으로 탐색하면서 limit 보다 큰 녀석은 power 로 재할당한다.

        int[] weapons = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            int temp = 0;
            for (int j = 1; j <= Math.sqrt(i) ; j++) { // 제곱근 사용
                if (i % j == 0){
                    temp++;
                    int otherDivisor = i / j; // 제곱근 사용하므로 제곱근 이상의 약수도 페어로 해서 찾을 수 있게 함
                    if (otherDivisor != j) {
                        temp++;
                    }
                }
            }

            weapons[i] = temp;
            temp = 0;
        }

        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] > limit){
                weapons[i] = power;
            }
        }

        int answer = 0;

        for (int weapon : weapons) {
            answer += weapon;
        }

        return answer;
    }

    public int solution0(int[] ingredient) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i : ingredient) {
            queue.add(i);
        }


        for (Integer integer : queue) {
            if (integer == 1){
                if (!queue.isEmpty() && queue.peek() == 2){
                    queue.poll();
                    if (!queue.isEmpty() && queue.peek() == 3){
                        queue.poll();
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public int solution(int[] ingredient) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int in : ingredient) {
            stack.push(in);
            if (stack.size() >= 4) {
                int size = stack.size();
                if(stack.get(size - 1) == 1
                        && stack.get(size - 2) == 3
                        && stack.get(size - 3) == 2
                        && stack.get(size - 4) == 1) {
                    result++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return result;
    }

}
