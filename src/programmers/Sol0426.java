package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sol0426 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/176963

    // name = 이름 yearning = 그리움점수, photo 는 name [][]

    // 맵으로 저장하고, 포토 돌면서 점수추가?
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> score = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }

        List<Integer> answer = new ArrayList<>();

        // for i 로 해서 돌면서, int의 i 번째 배열에 넣어버리자 걍

        for (int i = 0; i < photo.length; i++) {

            for (int j = 0; j < photo[i].length; j++) {
                if (score.containsKey(photo[i][j])) {
                    answer.set(i, score.get(photo[i][j]));
                }
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    public int[] solution2(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> nameIdxMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameIdxMap.put(name[i], i);
        }

        List<Integer> answer = new ArrayList<>();
        for (String[] pic : photo) {
            int score = 0;
            for (String nameInPic : pic) {
                if (nameIdxMap.containsKey(nameInPic)) {
                    int idx = nameIdxMap.get(nameInPic);
                    score += yearning[idx];
                }
            }
            answer.add(score);
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/42840

    //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, // 1, 2, 3, 4, 5, ...
    //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,  //  2, 1, 2, 3, 2, 4, 2, 5, ...
    //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, //  3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    //제한 조건
    //시험은 최대 10,000 문제로 구성되어있습니다.
    //문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    //가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

    public int[] solution(int[] answers) {
        int[] answer = {};
        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/12941

    public int solution(int []A, int []B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length-1-i];
        }


        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/12924

    //입출력 예
    //n	result -- > 1,2,3,4,5 / 4,5,6 / 7,8
    //15	4

    public int solution1(int n) {
        int answer = 0;

        int x = 1;

        while (x <= n){

            int sum = 0;

            for (int i = x; i <= n ; i++) {
                sum += i;
                if (sum == n){
                    answer++;
                    break;
                }
            }

            x ++;
        }

        return answer;
    }

    public int solution(int n) {
        int answer = 0;

        int start = 1;
        int end = 1;

        while (start <= n){

            int sum = 0;

            for (int i = start; i <= end ; i++) {
                sum += i;
            }

            if (sum == n) {
                answer++;
                start++;
            } else if (sum < n) {
                end++;
            } else {
                start++;
            }
        }

        return answer;
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/12911

    //자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
    //
    //조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
    //조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
    //조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
    //예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
    //
    //자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
    public int solution0(int n) {
        int answer = 0;
        int nTo1 = 0;

        String binaryString = Integer.toBinaryString(n);

        char[] charArray = binaryString.toCharArray();
        for (char c : charArray) {
            if (c == '1'){
                nTo1++;
            }
        }

        String biggerBinary = "";
        int biggerTo1 = 0;

        while (nTo1 != biggerTo1){
            n += 1;

        }


        return answer;
    }
}
