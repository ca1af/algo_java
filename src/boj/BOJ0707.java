package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ0707 {
    private static class BOJ1157 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String given = br.readLine(); // 주어진 문자열 그대로 유지

            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : given.toCharArray()) {
                char lowerCaseChar = Character.toLowerCase(c); // 소문자로 변환
                map.put(lowerCaseChar, map.getOrDefault(lowerCaseChar, 0) + 1);
            }

            int max = Integer.MIN_VALUE;
            boolean isMaxDuplicated = false;

            for (char character : map.keySet()) {
                int picked = map.get(character);
                if (picked == max) isMaxDuplicated = true;
                if (picked > max) {
                    isMaxDuplicated = false;
                    max = picked;
                }
            }

            if (isMaxDuplicated) {
                System.out.println("?");
            } else {
                for (char character : map.keySet()) {
                    if (map.get(character) == max) {
                        System.out.println(Character.toUpperCase(character));
                        break;
                    }
                }
            }
        }
    }
}
