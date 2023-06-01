package programmers;

public class PrefixSum {
    // https://school.programmers.co.kr/learn/courses/30/lessons/161988

    //1 ≤ sequence의 길이 ≤ 500,000
    //-100,000 ≤ sequence의 원소 ≤ 100,000
    //입출력 예
    //sequence	                    result
    //[2, 3, -6, 1, 3, -1, 2, 4]	10 (3, -6, 1에 1,-1,1 곱하므로 10)
    public long solution(int[] sequence) {
        // 요구사항 - 어쨌든 시퀀스안에서 누적합이 제일 큰 녀석 - 젤 작은 녀석
        // 그러면, pulse 1, pulse2 해서 누적합 배열을 두 개 만들어서, 누적합이 젤 큰놈 리턴되면 되나?
        // 예시의 누적합 구해보자
        // 2, {3, -6,1,} 3,-1, 2, 4

        // 2, -1, -7, -8, -5, -4, -2, -6 {1,-1...}

        // -2, 1,  7,  8,  5,  4,  2,  6 {-1,1,1} 양음만 반대다. 그럼 하나로 되겠는데?
        // 젤 큰놈 - 작은놈의 절댓값 = 10 (누적합의 차가 젤 큰놈이 구간합 최대니까)

        long[] prefixSum = new long[sequence.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            if (i % 2 == 0){
                prefixSum[i] = prefixSum[i - 1] + sequence[i - 1] * -1;
            } else {
                prefixSum[i] = prefixSum[i - 1] + sequence[i - 1];
            }
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] > max){
                max = prefixSum[i];
            }
            if (prefixSum[i] < min){
                min = prefixSum[i];
            }
        }

        return max - min;
    }
}
