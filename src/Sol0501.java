public class Sol0501 {
    //피보나치 수는 F(0) = 0, F(1) = 1일 때,
    // 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

    //https://school.programmers.co.kr/learn/courses/30/lessons/12945

    public int solution(int n) {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % 1234567;
        }

        return fib[n];
    }

}
