package boj;

import java.io.*;
import java.util.*;

public class BOJ0615 {
    public static class BOJ1934{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 입력 개수
            StringTokenizer st;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int gcd = gcd(a, b);
                int lcm = (a * b / gcd);
                bw.append(String.valueOf(lcm));
                if (i != N - 1) bw.append("\n");
            }

            bw.flush();
            bw.close();
            br.close();
        }

        public static int gcd(int a, int b){
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }

    public static class BOJ13241 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long N = sc.nextInt();
            long M = sc.nextInt();

            long gcd = gcd(N, M);
            long lcm = lcm(N, M, gcd);


            System.out.println(lcm);
        }

        public static long gcd(long a, long b){
            if (b == 0) return a;
            return gcd (b, a % b);
        }

        public static long lcm(long a, long b, long gcd){
            return (a * b) / gcd;
        }
    }

    public static class BOJ25192 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 입력수

            Set<String> set = new HashSet<>();

            int count = 0;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                if (line.equals("ENTER")){
                    count += set.size();
                    set.clear();
                } else {
                    set.add(line);
                }
            }

            count += set.size(); // 다 돌고나서 다시 더해줌

            System.out.println(count);
        }
    }

    public class BOJ1037 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int[] divisors = new int[N];

            for (int i = 0; i < N; i++) {
                divisors[i] = scanner.nextInt();
            }

            Arrays.sort(divisors);
            int result = divisors[0] * divisors[N - 1];

            System.out.println(result);
        }
    }

    public static class BOJ26069 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 입력수
            StringTokenizer st;

            HashSet<String> hashSet = new HashSet<>(); // 총총이랑 만난 녀석들을 모아둘 감옥

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String firstPerson = st.nextToken();
                String secondPerson = st.nextToken();

                if (firstPerson.equals("ChongChong") || secondPerson.equals("ChongChong")){
                    hashSet.add(firstPerson);
                    hashSet.add(secondPerson);
                }

                if (hashSet.contains(firstPerson) || hashSet.contains(secondPerson)) {
                    hashSet.add(firstPerson);
                    hashSet.add(secondPerson);
                }
            }

            System.out.println(hashSet.size());
        }
    }
}
