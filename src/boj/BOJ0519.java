package boj;

import java.util.*;

public class BOJ0519 {

    public class BOJ1152{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String line = sc.nextLine();

            int count = line.length() - line.trim().length();
            if (!line.startsWith(" ")){
                count += 1 ;
            }

            System.out.println(count);
        }
    }

    public class BOJ1712{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int fixedCharge = sc.nextInt();
            int cost = sc.nextInt();
            int profit = sc.nextInt();

            int quantity = 1;

            int margin = (quantity * profit) - fixedCharge - (cost * quantity);

            while (margin < 0){
                if (cost > profit){
                    quantity = -1;
                    break;
                }
                quantity++;
            }

            System.out.println(quantity);
        }
    }

    public class BOJ1978 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();

            int count = 0;

            for (int i = 0; i < N; i++) {
                int number = scanner.nextInt();

                if (isPrime(number)) {
                    count++;
                }
            }

            System.out.println(count);
        }

        // 소수인지 판별하는 함수
        public static boolean isPrime(int num) {
            if (num < 2) {
                return false;  // 2보다 작은 수는 소수가 아님
            }

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;  // 약수가 존재하면 소수가 아님
                }
            }

            return true;  // 약수가 존재하지 않으면 소수
        }
    }

    public class BOJ1427{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            char[] charArray = Integer.toString(sc.nextInt()).toCharArray();

            Arrays.sort(charArray);

            int parseInt = Integer.parseInt(Arrays.toString(charArray));

            System.out.println(parseInt);
        }
    }

    public class BOJ1158 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                queue.offer(i);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("<");

            while (!queue.isEmpty()) {
                for (int i = 0; i < K - 1; i++) {
                    queue.offer(queue.poll());
                }
                sb.append(queue.poll());

                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            }

            sb.append(">");
            System.out.println(sb.toString());
        }
    }

}
