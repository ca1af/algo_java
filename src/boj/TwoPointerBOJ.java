package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoPointerBOJ {
    public static class BOJ2018{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int targetInt = sc.nextInt();
            int start = 1;
            int end = 1;
            int count = 1;

            int sum = 1;

            while (start < targetInt){
                if (sum == targetInt){
                    count++;
                    sum -= start;
                    start++;
                } else if (sum > targetInt){
                    sum -= start;
                    start++;
                } else {
                    sum += end;
                    end++;
                }
            }

            System.out.println(count);
        }
    }

    public static class BOJ1940 {
        public static void main0(String[] args) {
            Scanner sc = new Scanner(System.in);

            int givenInts = sc.nextInt();

            int target = sc.nextInt();

            int[] numbers = new int[givenInts];

            for (int i = 0; i < givenInts; i++) {
                numbers[i] = sc.nextInt();
            }

            Arrays.sort(numbers);

            int answer = 0;
            int start = 0, end = givenInts - 1;

            while (start < end) {
                if (numbers[start] + numbers[end] == target) {
                    answer++;
                    start++;
                    end--; // 두 개의 조합으로만 작용하고, 중복이 없으므로
                } else if (numbers[start] + numbers[end] > target) {
                    end--;
                } else { // < target
                    start++;
                }
            }


            System.out.println(answer);
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int i=0, j=arr.length-1;
            int cnt = 0;

            while(i < j) {
                if(arr[i] + arr[j] == M) {
                    i++;
                    j--;
                    cnt++;
                }
                else {
                    if(arr[i] + arr[j] > M) {
                        j--;
                    }
                    else {
                        i++;
                    }
                }
            }

            bw.write(String.valueOf(cnt));

            br.close();
            bw.close();
        }
    }


}
