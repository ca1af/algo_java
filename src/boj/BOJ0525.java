package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ0525 {
    public class BOJ26215{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int amount = sc.nextInt();

            int[] houses = new int[amount];

            houses[0] = sc.nextInt();

            int count = 0;

            for (int i = 1; i < amount; i++) {
                int nextInt = sc.nextInt();
                if (houses[i - 1] != 0 && nextInt != 0){
                    houses[i - 1] -= 1;
                    houses[i] = nextInt - 1;
                    count++;
                } else {
                    houses[i] = nextInt;
                }
            }

            for (int house : houses) {
                count += house;
            }

            if (count > 1440){
                System.out.println(-1);
            } else {
                System.out.println(count);
            }

            // 1440 분 이상 걸리면 -1 리턴


        }
    }

    public class BOJ17478 {
        static int n;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());

            System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

            recur(0, "");

        }

        public static void recur(int depth, String under) {

            if (depth == n) {
                System.out.println(under + "\"재귀함수가 뭔가요?\"");
                System.out.println(under + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
                System.out.println(under + "라고 답변하였지.");
                return;

            }

            System.out.println(under + "\"재귀함수가 뭔가요?\"");
            System.out.println(under + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(under + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(under + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");


            recur(depth + 1, under + "____");
            System.out.println(under + "라고 답변하였지.");
        }

    }

    public class BOJ20112{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int length = sc.nextInt();

            int[][] sator = new int[length][length];

            for (int[] ints : sator) {

            }


        }
    }

    public class BOJ1181 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int nextInt = sc.nextInt();

            String[] arr = new String[nextInt];

            for (int i = 0; i < nextInt; i++) {
                String s = sc.nextLine();
                arr[i] = s;
            }

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    } else {
                        return o1.length() - o2.length();
                    }
                }
            });

            System.out.println(arr[0]);
            for (int i = 1; i < nextInt; i++) {
                if (!arr[i].equals(arr[i - 1])) {
                    System.out.println(arr[i]);
                }
            }

        }
    }

    public static class BOJ1316 {
        public static void main(String[] args) {
            // ccaabb O
            // bbabcc X ( b 동떨어져 나타나므로 )

            // 어쨋든 문자열을 입력 받아야겠지 개수만큼

            Scanner sc = new Scanner(System.in);

            int nextInt = sc.nextInt();

            String[] arr = new String[nextInt];

            for (int i = 0; i < nextInt; i++) {
                arr[i] = sc.nextLine();
            }

            // 문자열을 돌면서 검증해야겠지
            // 1. 문자열을 돌면서 검증한다
            // 2. prev 라는 변수를 설정해서, prev와 같으면 계속 진행, 다르면 리스트에 저장한다 { c,a,b } { b,a,b,c }
            // 3. 리스트를 돌면서 중복되는 녀석이 있으면 0, 중복되는 녀석이 없으면 +1 을 더한다.

            int answer = 0;

            for (String s : arr) {
                answer += isUnique(s);
            }

            System.out.println(answer);
        }

        private static int isUnique(String s) {
            char prev = ' ';

            char[] charArray = s.toCharArray();

            List<Character> chars = new ArrayList<>();

            int answer = 1;

            for (char c : charArray) {
                if (c != prev) {
                    prev = c;
                    chars.add(c);
                }
            }

            char prev2 = ' ';

            for (Character element : chars) {
                if (chars.indexOf(element) != chars.lastIndexOf(element)) {
                    answer = 0;
                }
            }
            return answer;
        }
    }


    public static class BOJ1343 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String line = sc.nextLine(); // 입력 받는 부분

            String poliomino = poliomino(line); // 매서드로 뺀 부분

            System.out.println(poliomino);

            sc.close();
        }

        private static String poliomino(String line) {
            int idx = 0; // 인덱스를 카운트해서 조작하기 위함(line)

            StringBuilder sb = new StringBuilder(); // 조작 후 바로 빌더에 넣기위해

            while (idx < line.length()){
                if (line.charAt(idx) == 'X'){
                    int count = 0;
                    while (idx < line.length() && line.charAt(idx) == 'X'){
                        count++;
                        idx++;
                    }

                    if (count % 2 != 0){
                        return "-1";
                    }

                    while (count >= 4){
                        sb.append("AAAA");
                        count -= 4;
                    }

                    while (count >= 2){
                        sb.append("BB");
                        count -= 2;
                    }
                } else {
                    sb.append(".");
                    idx++;
                }
            }

            return sb.toString();
        }
    }
    public static class BOJ1748{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int test = 1;

            int targetInt = sc.nextInt();

            int digit = 1;

            int multiple = 10;

            int answer = 0;

            // targetInt -> 231 이라 치자.

            while (test <= targetInt){
                if (test % multiple == 0){
                    multiple *= 10;
                    digit++;
                }
                answer += digit;
                test++;
            }

            System.out.println(answer);
        }
    }

}
