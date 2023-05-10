package boj;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ0509 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();

        System.out.println(i - 543);
    }

    private class Main2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                System.out.println(a + b);
            }
        }
    }

    public class B10950 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                System.out.println(a + b);
            }
        }
    }

    public class B8393 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int anInt = scanner.nextInt();

            int answer = 0;

            while (anInt != 0) {
                answer += anInt;
                anInt--;
            }

            System.out.println(answer);
        }
    }

    //260000
    //4
    //20000 5
    //30000 2
    //10000 6
    //5000 8

    public class B25304 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int total = scanner.nextInt();
            int quantity = scanner.nextInt();

            int actualTotal = 0;

            while (scanner.hasNext()) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                actualTotal += a * b;
            }

            if (total == actualTotal)
                System.out.println("Yes");
            else System.out.println("No");
        }
    }

    public class B25314 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int input = scanner.nextInt()/4;

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 1; i <= input; i++) {
                stringBuilder.append("long ");
            }

            System.out.println(stringBuilder + "int");
        }
    }

    public class B15552 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;

            int parsedInt = Integer.parseInt(br.readLine());

            for (int i = 0; i < parsedInt; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
            }

            br.close();
            bw.flush();
            bw.close();
        }
    }

    public class B11021 {
        public static void main(String args[]) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;

            int parsedInt = Integer.parseInt(br.readLine());

            for (int i = 1; i <= parsedInt; i++) {
                st = new StringTokenizer(br.readLine()," ");
                bw.write("Case #"+i+": ");
                bw.write(Integer.parseInt(st.nextToken())
                        +Integer.parseInt(st.nextToken())+"\n");
            }
            br.close();
            bw.flush();
            bw.close();
        }

    }
}
