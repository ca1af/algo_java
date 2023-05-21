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
}
