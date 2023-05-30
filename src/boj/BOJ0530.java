package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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
}
