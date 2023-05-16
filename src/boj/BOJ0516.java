package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ0516 {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int max = 0; // 최댓값을 저장할 변수
            int index = 0; // 최댓값의 인덱스를 저장할 변수

            for (int i = 1; i <= 9; i++) {
                int num = sc.nextInt();

                if (num > max) {
                    max = num;
                    index = i;
                }
            }

            System.out.println(max);
            System.out.println(index);
        }
    }


    public class BOJ3052{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            HashSet<Integer> set = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                int anInt = sc.nextInt() % 42;
                set.add(anInt);
            }

            System.out.println(set.size());
        }
    }

    public class BOJ2750 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int count = sc.nextInt();

            int[] arr = new int[count];

            for (int i = 0; i < count; i++) {
                arr[i] = sc.nextInt();
            }

            int n = arr.length;
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-1; j++) {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }

            for (int i : arr) {
                System.out.println(i);
            }


        }
    }
}
