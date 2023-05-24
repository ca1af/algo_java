package programmers;

import java.util.Arrays;

public class Sol2_0406 {
    public int solution1(int n, int[] lost, int[] reserve) {
        return Math.min(n - (lost.length - reserve.length), n);
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        Arrays.fill(students, 1); // 모든 학생들에게 체육복이 있다고 가정

        // 체육복을 도난당한 학생
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]-1]--;
        }

        // 여벌의 체육복이 있는 학생
        for (int i = 0; i < reserve.length; i++) {
            students[reserve[i]-1]++;
        }

        // 체육복을 빌려주기
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                if (i-1 >= 0 && students[i-1] > 1) { // 바로 앞 학생에게 빌려줄 수 있는 경우
                    students[i]++;
                    students[i-1]--;
                } else if (i+1 < students.length && students[i+1] > 1) { // 바로 뒷 학생에게 빌려줄 수 있는 경우
                    students[i]++;
                    students[i+1]--;
                }
            }
        }

        // 수업을 들을 수 있는 학생 수 계산
        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
