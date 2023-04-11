public class Sol0410 {
    public int solution(int[] numbers, int k) {
        int current = 0;
        while (true) {
            int next = (current + k) % numbers.length;
            if (next == 0) {
                next = numbers.length;
            }
            if (next == 1) {
                return current + 1;
            }
            current = next - 1;
        }
    }
}
