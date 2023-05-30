package boj;

import java.util.*;

public class BOJ0530 {
    public class BOJ11650{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int[][] points = new int[n][2];

            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            Arrays.sort(points, (o1, o2) -> {
                if (o1[0] == o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            });

            for (int i = 0; i < n; i++) {
                System.out.println(points[i][0] + " " + points[i][1]);
            }
        }
    }

    public class BOJ11651{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int[][] points = new int[n][2];

            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            Arrays.sort(points, (o1, o2) -> {
                if (o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            });

            for (int i = 0; i < n; i++) {
                System.out.println(points[i][0] + " " + points[i][1]);
            }
        }
    }


    public class BOJ10814 {
        // String[][] 사용한 풀이
        public static void main0(String[] args) {

            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            String[][] arr = new String[N][2];


            for(int i = 0; i < N; i++) {
                arr[i][0] = sc.next();    // 나이
                arr[i][1] = sc.next();    // 이름
            }


            Arrays.sort(arr, new Comparator<String[]>() {
                // 나이순으로 정렬
                @Override
                public int compare(String[] s1, String[] s2) {
                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
                }

            });

            for(int i = 0; i < N; i++) {
                System.out.println(arr[i][0] + " " + arr[i][1]);
            }


        }


        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Member[] members = new Member[n];

            for (int i = 0; i < n; i++) {
                int age = sc.nextInt();
                String name = sc.next();
                members[i] = new Member(age, name);
            }

            Arrays.sort(members, new Comparator<Member>() {
                @Override
                public int compare(Member m1, Member m2) {
                    return Integer.compare(m1.getAge(), m2.getAge());
                }
            });

            for (Member member : members) {
                System.out.println(member.getAge() + " " + member.getName());
            }
        }
    }

    class Member {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

    // TODO: 2023/05/30 https://www.acmicpc.net/problem/18870 

    public static class BOJ18870{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int length = sc.nextInt();

            int[] ints = new int[length];

            for (int i = 0; i < length; i++) {
                ints[i] = sc.nextInt();
            }

            Arrays.sort(ints);

            int temp = 0;

            for (int i = 0; i < ints.length; i++) {
                if (temp == ints[i]){
                    ints[i] = ints[i-1];
                } else {
                    ints[i] = i;
                }
                temp = ints[i];
            }

            StringBuilder sb = new StringBuilder();

            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }

            System.out.println(sb);
        }
    }

    public static class BOJ14003{
        public static void main(String[] args) {
            //예를 들어,
            // A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은
            // A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

            Scanner sc = new Scanner(System.in);

            int totalCount = sc.nextInt();

            int[] ints = new int[totalCount];

            for (int i = 0; i < totalCount; i++) {
                ints[i] = sc.nextInt();
            }

            int temp = 0;

            ArrayList<Integer> arr = new ArrayList<>();

            for (int anInt : ints) {
                if (temp < anInt){
                    arr.add(anInt);
                }
                temp = anInt;
            }


            StringBuilder sb = new StringBuilder();

            for (Integer integer : arr) {
                sb.append(integer).append(" ");
            }

            System.out.println(arr.size());
            System.out.println(sb);

        }
    }

}
