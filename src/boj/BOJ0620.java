package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ0620 {
    public static class BOJ20920 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<String, Integer> wordMap = new HashMap<String, Integer>();

            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                if (word.length() < m) continue; // 길이가 m 이하인 단어들 제거

                Integer count = wordMap.getOrDefault(word, 0);
                wordMap.put(word, count + 1); // <단어, 빈도수> 추가
            }
            List<String> words = wordMap.keySet().stream().sorted((o1, o2) -> {
                int c1 = wordMap.get(o1);
                int c2 = wordMap.get(o2);

                if (c1 == c2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
                    }
                    return o2.length() - o1.length(); // 해당 단어의 길이가 길수록 앞에
                }
                return c2 - c1; // 자주 나오는 단어일수록 앞에
            }).collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i)).append("\n");
            }
            System.out.println(sb);
        }
    }

    public static class BOJ1806 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 구하고자 하는 숫자의 개수
            int S = Integer.parseInt(st.nextToken()); // 목표 합

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int given = Integer.parseInt(st.nextToken());
                arr[i] = given;
            }

            int startIdx = 0;
            int endIdx = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            while (true) {
                if (sum >= S) { // 누적합보다 크다면
                    sum -= arr[startIdx++];
                    min = Math.min(endIdx - startIdx, min);
                } else if (endIdx == N) {
                    break;
                } else {
                    sum += arr[endIdx++];
                }
            }

            if (min != Integer.MAX_VALUE) System.out.println(min);
            else System.out.println(0);

        }
    }
}