package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ0705 {
    public static class BOJ1644 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); // 주어지는 자연수 N

            // 1. 에라토스테네스의 체로 걸러주기 ( N이하인 녀석들 )
            // 2. 투포인터 조지기. 완전히 N과 같다면 + 1 해줌.
            // 3. 범위는 N까지이며, str 가 계속 늘어나면서 검정한다. 마지막 N만 남으면 종료하며, N 이 소수이면 카운트를 ++

            ArrayList<Integer> prime = primeList(n); // 누적합을 만들면?

            int sum = (prime.size() < 0) ? 0 : prime.get(0);
            int left = 0;
            int right = 0;
            int ans = 0;

            while (left <= right && right < prime.size()) {
                if (sum <= n) {
                    if (sum == n) ans++;
                    right++;
                    if (right < prime.size()) { //증가시킨 right가 리스트 크기를 벗어나면 안됨!
                        sum += prime.get(right);
                    }
                } else if (sum > n) {
                    sum -= prime.get(left);
                    left++;
                    if (left < prime.size() && left > right) {
                        left = right;
                        sum = prime.get(right);
                    }
                }
            }

            System.out.println(ans);
        }
        private static ArrayList<Integer> primeList(int N) {
            boolean[] booleans = new boolean[N + 1];
            Arrays.fill(booleans, true);
            booleans[0] = booleans[1] = false;

            for (int i = 2; i < booleans.length; i++) {
                for (int j = i * i; j < booleans.length; j += i) {
                    booleans[j] = false;
                }
            }

            ArrayList<Integer> primes = new ArrayList<>();

            for (int i = 0; i < booleans.length; i++) {
                if (booleans[i]) primes.add(i);
            }

            return primes;
        }

    }

    public static class BOJ1253 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 들어오는 수의 개수
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int ai = Integer.parseInt(st.nextToken());
                arrayList.add(ai);
            }

            Collections.sort(arrayList);

            int count = 0;

            for (int i = 0; i < N; i++) {
                int target = arrayList.get(i);
                int start = 0;
                int end = N - 1;

                while (start < end) {
                    int sum = arrayList.get(start) + arrayList.get(end);

                    if (sum == target) {
                        if (start != i && end != i) { // 합을 이루는 수가 서로 다른 위치에 있을 경우
                            count++;
                            break;
                        } else if (start == i) {
                            start++;
                        } else { // end == i
                            end--;
                        }
                    } else if (sum > target) {
                        end--;
                    } else { // sum < target
                        start++;
                    }
                }
            }

            System.out.println(count);
        }
    }

}

