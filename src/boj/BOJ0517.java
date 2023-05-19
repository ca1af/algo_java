package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ0517 {
    public class BOJ2798{
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);

            int count = sc.nextInt();
            int max = sc.nextInt();
            int[] cards = new int[count];

            for (int anInt : cards) {
                anInt = sc.nextInt();
            }

            int answer = 0;

            for (int i = 0; i < count - 2; i++) {
                for (int j = 0; j < count - 1; j++) {
                    for (int k = 0; k < count; k++) {
                        int sum = cards[i] + cards[j] + cards[k];
                        if (sum <= max && sum > answer){
                            answer = sum;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public class BOJ2798_2 {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);

            int count = sc.nextInt();
            int max = sc.nextInt();
            int[] cards = new int[count];

            for (int i = 0; i < count; i++) {
                cards[i] = sc.nextInt();
            }

            int answer = 0;

            for (int i = 0; i < count - 2; i++) {
                for (int j = i + 1; j < count - 1; j++) {
                    for (int k = j + 1; k < count; k++) {
                        int sum = cards[i] + cards[j] + cards[k];
                        if (sum <= max && sum > answer) {
                            answer = sum;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }

    //첫째 줄에 (A+B)%C,
//둘째 줄에 ((A%C) + (B%C))%C,
//셋째 줄에 (A×B)%C, 넷째 줄에
//((A%C) × (B%C))%C를 출력한다.



    public class BOJ2884{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int time = sc.nextInt();
            int minute = sc.nextInt();

            if (time - 1 < 0){
                time = 23;
            } else {
                time -= 1;
            }

            if (minute + 15 >= 60){
                minute = minute + 15 - 60;
            } else {
                minute += 15;
            }

            System.out.println(time + " " + minute);
        }
    }

    public class BOJ2525{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int time = sc.nextInt();
            int minute = sc.nextInt();
            int input = sc.nextInt();


        }
    }

    public class BOJ3003 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] pieces = {1, 1, 2, 2, 2, 8}; // 정답 체스 말 개수

            for (int i = 0; i < 6; i++) {
                int count = scanner.nextInt(); // 입력된 체스 말 개수
                int diff = pieces[i] - count; // 정답과의 차이 계산
                System.out.print(diff + " ");
            }
        }
    }

    public class BOJ10988{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            int answer = 1;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (int j = charArray.length; j >= 0; j--) {
                    if (charArray[i] != charArray[j]){
                        answer = 0;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public class BOJ1110{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int origin = n;
            int answer = 0;

            do {
                int ten = n / 10;
                int one = n % 10;
                int sum = ten + one;
                n = one + sum % 10;
                answer++;
            } while (answer != origin);

            System.out.println(answer);
        }
    }

    public class BOJ4344{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int problems = sc.nextInt();

            for (int i = 0; i < problems; i++) {
                int students = sc.nextInt();
                int[] scores = new int[students];

                int sum = 0;
                for (int j = 0; j < students; j++) {
                    scores[j] = sc.nextInt();
                    sum += scores[j];
                }

                double average = (double) sum / students;

                int decentStudents = 0;

                for (int k = 0; k < scores.length; k++) {
                    if (scores[k] > average){
                        decentStudents++;
                    }
                }

                double aboveAverageRatio = (double) decentStudents / students * 100;
                System.out.printf("%.3f%%\n", aboveAverageRatio);
            }

            sc.close();
        }
    }

    public class BOJ2751{

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            Arrays.sort(arr);

            for (int num : arr) {
                System.out.println(num);
            }
        }
    }
    public class BOJ1316{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String answer = "No";

            while (sc.hasNext()){
                if (sc.nextInt() == 0){
                    break;
                }
            }
        }
    }
}
