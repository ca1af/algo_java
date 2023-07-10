package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ0710 {
    public static class BOJ9935 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String given = br.readLine(); // 주어지는 문자열
            String explosive = br.readLine(); // 폭발하는 녀석
            Stack<Character> stack = new Stack<>();

        }
    }

    // TODO: 2023/07/10 다시다시
    public static class BOJ24060 {
        static int[] temp;
        static int count = 0;
        static int K;
        static int result = -1;
        public static void main(String[] args){

            Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();
            int[] arr = new int[num];
            K = sc.nextInt();

            temp = new int[num];

            for(int i = 0 ; i < num ; i++){
                arr[i] = sc.nextInt();
            }

            sc.close();

            merge_sort(arr, 0, arr.length - 1);
            System.out.print(result);
        }

        static void merge_sort(int A[], int low, int high){

            if(low < high){
                int mid = (low + high) / 2;
                merge_sort(A, low, mid);
                merge_sort(A, mid + 1, high);
                merge(A, low, mid, high);
            }
        }

        static void merge(int A[], int low, int mid, int high){
            int i = low;
            int j = mid + 1;
            int t = 0;


            while(i <= mid && j <= high){
                if(A[i] <= A[j]){
                    temp[t++] = A[i++];
                }else{
                    temp[t++] = A[j++];
                }
            }

            while(i <= mid){
                temp[t++] = A[i++];
            }

            while(j <= high){
                temp[t++] = A[j++];
            }

            t = 0;
            i = low;

            while(i <= high){
                count++;
                if(count==K){
                    result = temp[t];
                    break;
                }
                A[i++] = temp[t++];
            }
        }
    }

    public static class BOJ25418 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 작은 수
            int M = Integer.parseInt(st.nextToken()); // 큰 수
            int count = 0;

            while (M != N){
                if (M % 2 == 0){
                    M /= 2;
                    count++;
                } else {
                    M -= 1;
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
