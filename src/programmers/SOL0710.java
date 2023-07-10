package programmers;

import java.util.*;

public class SOL0710 {
    static class isMaxisMin {
        // https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java
        public String solution(String s) {
            String answer = "";
            StringTokenizer st = new StringTokenizer(s);
            ArrayList<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()){
                int i = Integer.parseInt(st.nextToken());
                list.add(i);
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (Integer integer : list) {
                if (integer > max) max = integer;
                if (integer < min) min = integer;
            }

            return min + " " + max;
        }
    }

    static class Sol2{
        public static int solution(int[] elements) {
            Set<Integer> set = new HashSet<>();

            int start = 1;

            while (start <= elements.length) {
                for (int i = 0; i < elements.length; i++) {
                    int value = 0;
                    for (int j = i; j < i + start; j++) {
                        value += elements[j % elements.length];
                    }
                    set.add(value);
                }
                start++;
            }

            return set.size();
        }
    }
}
