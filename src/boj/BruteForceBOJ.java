package boj;

import java.util.Scanner;

public class BruteForceBOJ {
    public class BOJ2231{
        public static void main0(String[] args) {
            Scanner sc = new Scanner(System.in);

            int target = sc.nextInt();

            int sum = 0;

            int answer = 0;

            for (int i = 0; i < target; i++) {
                char[] charArray = Integer.toString(i).toCharArray();
                for (char c : charArray) {
                    sum += (c - '0');
                    if (sum == target){
                        answer = i;
                        break;
                    }
                }
            }

            System.out.println(answer);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int target = sc.nextInt();

            int answer = 0;

            for (int i = 1; i < target; i++) {
                int sum = i;
                int num = i;

                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }

                if (sum == target) {
                    answer = i;
                    break;
                }
            }

            System.out.println(answer);
        }
    }


    public static class BOJ2839 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int targetNum = sc.nextInt();

            // 5키로 봉지와 3키로 봉지로 타겟넘버 다 옮겨야함
            // 무슨 봉지로 옮기든 카운트 +1

            // idea
            // 1. 타겟에서 -3 계속 반복하면서 answer ++; , 5로 나눠지는 시점에는 5로 나눈 몫을 answer 에 더하기
            // 3으로 계쏙 나눠도 5로 안나눠떨어지고 targetNum 이 0 이하가 된다면, -1 리턴하기
            int answer = 0;

            while (targetNum > 0){
                if (targetNum % 5 == 0){
                    answer += targetNum / 5 ;
                    targetNum = 0;
                    break;
                }

                targetNum -= 3;
                answer ++;
            }


            if (targetNum == 0){
                System.out.println(answer);
            }else {
                System.out.println(targetNum);
            }

        }
    }


}
