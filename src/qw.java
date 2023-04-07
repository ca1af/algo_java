//최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
// 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
// 최빈값이 여러 개면 -1을 return 합니다.

//array	result
//[1, 2, 3, 3, 3, 4]	3
//[1, 1, 2, 2]	-1
//[1]	1

public class qw {
    public int solution(int[] array) {
        int[] freqArr = new int[100001];
        int maxFreq = 0;
        int mode = -1;
        boolean isMultipleModes = false;

        for (int num : array) {
            freqArr[num]++;

            if (freqArr[num] > maxFreq) {
                maxFreq = freqArr[num];
                mode = num;
                isMultipleModes = false;
            } else if (freqArr[num] == maxFreq) {
                isMultipleModes = true;
            }
        }

        if (isMultipleModes) {
            return -1;
        } else {
            return mode;
        }
    }
}
