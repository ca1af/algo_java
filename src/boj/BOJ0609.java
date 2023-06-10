package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ0609 {
    public static class BOJ13305 {
        //4
        //2 3 1 이동에 필요한 거리
        //5 2 4 1 가격 , 사싦상 마지막 녀석은 필요가 없다
        // 5, 2, 4 까지만 초기화하면 된다 -> {2, 3, 1] // [5, 2, 4} 가격.

        // 1. 0번 인덱스(5) 에 있는 녀석은 무조건 구매를 해야한다. // 5 * 2 만큼 구매해야한다
        // 2. 다음 인덱스의 가격이 이전보다 적다면, 다음 인덱스에서 "이동에 필요한 거리"만큼 구매한다 // 2 * 3 만큼 구매해야 한다
        // 3. 만약 가격이 나보다 적은 녀서

        // 1. 0번 인덱스에서 무조건 구매
        // 2. 가격이 적은 녀석이 나올때까지 idx++해서, {5, 2, 1, 3} 이렇다치면 5-> 2에서 사고, 찾았으면 "나" 보다 가격이 적은 녀석이 나올때까지는 달려야지
        // 3. 만약 가격이 더 낮은 녀석이 나온다면 나 이후의 거리를 쭉 사는거지

        // 정리
        // 0번 인덱스에서 산다. 나보다 더 작은 녀석이 나올때까지
        // 0번 인덱스보다 작은녀석 (임의 i) 발견, i가 나오기 전까지 거리는 전부 0번 인덱스 가격 * 거리 만큼 구매해야 한다
        // i 번 인덱스부터 쭉 산다. i번 인덱스보다 작은 녀석이 나오면 거기까지만 사고 거기서부터는 더 작은 녀석으로 구매
        // 반복

        // 실제 구현 어떻게 되어야 할까
        // 5 -> 2 여기서 작은놈이 걸린다. 따라서 0번 도로만큼의 거리 이동 --> 인덱스간의 차이 - 1 ~
        // 예를 들어 { 5, 5, 2 } 에 {1, 2, 3} 이라면?
        // 5 가격으로 세번(1,2) 사고, 2가격으로 3번 사야함
        // 즉 해당하는 인덱스의 가격으로 걍 사면 되네. prices[i] * distances[i] += sum;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()) - 1; // 마지막 녀석은 입력받을 필요가 없으며, 경로간 거리는 N-1이므로 -1
            StringTokenizer st;
            int[] prices = new int[N];
            int[] distances = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { // 거리먼저 주어지므로 거리부터 받는다
                distances[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int lowerPrice = prices[0]; // 최저가를 갱신해주기 위함 {5 -> 2 -> 4 -> 4} 면 5에서 2로 갱신될것
            long sum = 0;

            for (int i = 0; i < prices.length; i++) {
                if (lowerPrice > prices[i]) lowerPrice = prices[i];
                sum += (long) lowerPrice * distances[i]; // 최저가를 갱신해가면서
            }

            System.out.println(sum);
        }
    }

    public static class BOJ2470 {
        public static void main(String[] args) throws IOException {
            // 요구사항 - N개만큼 주어지는 수들 중, 2개의 조합으로 절대값이 가장 작은 수를 만들 수 있는 경우를 찾고, 그 두 수를 리턴해라

            // 투 포인터로 풀 수 있나?
            // -2 4 -99 -1 98 매 라인마다 투포인터?

            // -2, 4 로 시작해서 long temp = Math.abs(-2 + 4) 저장
            // startIdx, endIdx 해서 쭉쭉 만나게해보자

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // N개 만큼 주어지는 수들
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr); // 정렬해줌

            int startPointer = 0;
            int endPointer = N - 1; // 인덱스에 대한 탐색을 하므로

            long temp = Integer.MAX_VALUE;

            int[] answer = new int[2]; // 합친 두 너석들을 넣어주기 위함

            while (startPointer < endPointer) { // 둘이 만나기 전에 브레이크 해야함
                int sum = arr[startPointer] + arr[endPointer]; // 포인터 옮겨주는 옵션 넣어주려고
                int value = Math.abs(arr[startPointer] + arr[endPointer]);

                if (value < temp) { // 두 개를 합친 값이 temp보다 작으면
                    temp = value;
                    answer[0] = arr[startPointer]; // 무조건 왼쪽놈이 작으므로(정렬됨)
                    answer[1] = arr[endPointer];
                }

                if (sum > 0) endPointer--;
                else startPointer++;

            }

            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public class BOJ12865 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 입력받을 라인 수
            int K = Integer.parseInt(st.nextToken()); // 최대 무게 제한

            // 컨셉은, 만족도를 크기별로 쭉 정렬한 다음에
            // 만족도 큰 놈들부터 무게를 받아와서, 1. 무게가 오버되면 2. 합산하지 않은 무게를 ArrayList 에 add
            // 큰 놈부터 요소들끼리 합치는 작업을 반복해서, 최댓값 갱신해서 sout

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()); // 라인 하나 받아와서
                int weight = Integer.parseInt(st.nextToken()); // 무게
                int value = Integer.parseInt(st.nextToken()); // 만족도(==가치)

                map.put(value, weight); // map.keySet() 에서 밸류를 찾아서 할거니까?
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (Integer integer : map.keySet()) {
                queue.add(integer); // 큰놈부터 들어감 어차피
            }

            int max = 0;

            while (!queue.isEmpty()) {
                int sum = 0;
                while (sum < K) { // poll 해서 가져온 값들이

                }
            }


        }
    }

    // TODO: 2023/06/10 다시
    public class BOJ11000 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[][] lectures = new int[N][2];

            for (int i = 0; i < N; i++) {
                lectures[i][0] = sc.nextInt();
                lectures[i][1] = sc.nextInt();
            }

            Arrays.sort(lectures, (a, b) -> a[0] - b[0]);

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(lectures[0][1]);

            for (int i = 1; i < N; i++) {
                if (lectures[i][0] >= pq.peek()) {
                    pq.poll();
                }
                pq.offer(lectures[i][1]);
            }

            System.out.println(pq.size());

            sc.close();
        }
    }

}
