package boj;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgoT {
    public static class HubDNC1 {
        //[ { answer : 1, score : 5 }, { answer : 3, score : 3 }, { answer : 2, score : 4 } ] → a : 5
        // a 는 1번으로 모두 찍었고, 따라서 5점 얻었음. B는 3번으로 모두 찍었고, 따라서 3 점 얻음. C는 5번으로 모두 찍었고, 0점 얻음
        //[ { answer : 1, score : 5 }, { answer : 5, score : 5 }, { answer : 2, score : 4 } ] → a : 5, c : 5
        // A(1) : 5, B(3) : 0, C(5) : 5 -> a : 5, c : 5
        static HashMap<String, Integer> map = new HashMap<>();

        public String num1Param(ArrayList<HashMap<String, Integer>> arr) {
            // 정답 맵을 만들어서 비교함

            for (int i = 0; i < arr.size(); i++) {
                HashMap<String, Integer> hashMap = arr.get(i);
                Integer answer = hashMap.get("answer");
                Integer score = hashMap.get("score");
                calculateScore(answer, score);
            }
            // 최대값에 해당하는 키들을 저장해서, 마지막에 출력해주자
            ArrayList<String> maxKeys = new ArrayList<>();
            int maxValue = Integer.MIN_VALUE;

            for (String key : map.keySet()) {
                int value = map.get(key);

                if (value > maxValue) {
                    maxValue = value;
                    maxKeys.clear(); // 재할당이 일어난 경우 리스트를 싹 날려야함 ( 이전 최댓값들은 의미가 없어짐 )
                    maxKeys.add(key);
                } else if (value == maxValue) {
                    maxKeys.add(key); // 맥스값과 같은값이면 넣음
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String maxKey : maxKeys) {
                sb.append(maxKey).append(" : ").append(",");
            }
            sb.setLength(sb.length() - 1); // 다 추가하고 마지막에 존재하는 ,(쉼표) 제거

            return sb.toString();
        }

        public static void calculateScore(int answer, int score) {
            if (answer == 1) {
                map.put("a", map.getOrDefault("a", 0) + score);
            } else if (answer == 3) {
                map.put("b", map.getOrDefault("a", 0) + score);
            } else if (answer == 5) { //answer 는 다른 입력이 들어 올 수 있으므로
                map.put("c", map.getOrDefault("c", 0) + score);
            }
        }
    }

    public static class HubDNC2 {

        //    양의 정수의 배열 arr이 주어질 때 모든 원소들이 둘 씩 짝지어 생기는 최소공배수를 합한 값을 리턴하는 solution 함수를 작성해주세요.
        public int num2(int[] arr){
            // 1,2 / 1,3 / 2,3 식으로 모든 combination 에 대해서 공배수를 더해서 리턴하면 된다.
            // 계산 과정을 살펴보면
            // 1-> 2,3,4,5,6
            // 2-> 3,4,5,6
            // 3 -> 4,5,6
            // 4 -> 5,6
            // 5 -> 6
            // 이런식으로 될 것
            // 브루트포스...인듯?
            int answer = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) { // i 보다 1 커야함
                    int gcd = gcd(arr[i], arr[j]);
                    answer += (arr[i] * arr[j] / gcd); // 최소 공배수를 구해서 answer 에 더해줌
                }
            }
            return answer;
        }

        public int gcd(int a, int b){ // 유클리드 호제법 사용한 최대공약수
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }

    public static class HubDNC3 {
        public int decimalSum(int a){
            // 1. 2~a 중 소수인녀석들만 저장할 int[] 선언
            // 2. for 로 합계 리턴
            int[] arr = new int[a + 1];

            for (int i = 2; i <= a; i++) {
                arr[i] = i; // 2 ~ a까지 배열 채워넣음 (0, 1은 소수가 아니므로)
            }

            for (int i = 2; i <= a ; i++) {
                for (int j = i * i; j <= a ; j += i) {
                    arr[j] = 0; // 소수가 아니므로 합해서는 안됨. 따라서 값을 0으로 만들어줌
                }
            }

            int sum = 0;

            for (int i = 2; i <= a; i++) {
                sum += arr[i]; // 2 ~ a 중 소수인 값을 더해줌
            }

            return sum;
        }
    }
}