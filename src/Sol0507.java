import java.util.*;

public class Sol0507 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/12981
    //["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]

    public int[] solution1(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        boolean flag = true;

        for(int i=0; i<words.length; i++){
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)
                    || list.contains(words[i])){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }

            list.add(words[i]);
        }
        if(flag) return new int[]{0, 0};
        return answer;
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/42579
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], plays[i]);
        }



        int[] answer = {};
        return answer;
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5; // 캐시 사이즈가 0일경우 전부 cache miss 이므로
        }

        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분을 하지 않으므로 모두 소문자로 변환
            int index = cache.indexOf(city); // 캐시에서 해당 도시가 있는 인덱스를 찾음
            if (index != -1) { // 캐시에 해당 도시가 있을 경우
                cache.remove(index); // 해당 도시를 삭제하고
                cache.add(city); // 캐시의 맨 뒤에 추가하여 최근에 사용되었음 표시
                answer += 1; // 실행시간을 1 증가
            } else { // 캐시에 해당 도시가 없을 경우
                if (cache.size() >= cacheSize) { // 캐시가 가득 찼으면
                    cache.remove(0); // 캐시의 맨 앞의 도시를 삭제하고
                }
                cache.add(city); // 해당 도시를 캐시에 추가하고

                answer += 5; // 실행시간을 5 증가
            }
        }
        return answer;
    }

    public int solution(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++){
            if (stack.peek() == chars[i]){
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }

    public int solution(int n) {
        int countOne = intToBinaryAndCountOne(n);
        n += 1 ;

        while (countOne != intToBinaryAndCountOne(n)){
            n++;
        }

        return n;
    }

    private int intToBinaryAndCountOne(int n) {
        int count = 0;
        String nToBinary = Integer.toBinaryString(n);
        char[] charArray = nToBinary.toCharArray();
        for (char c : charArray) {
            if (c == '1'){
                count++;
            }
        }
        return count;
    }
}
