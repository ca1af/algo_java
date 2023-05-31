package boj;

import java.util.*;

public class BOJ0531 {
    public class BOJ1874{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int num = 1;

            Stack<Integer> stack = new Stack<>();

            StringBuilder sb = new StringBuilder();

            boolean result = true;

            for (int i = 0; i < arr.length; i++) {
                int picked = arr[i];
                if (picked >= num){
                    while(picked >= num){
                        stack.push(num++);
                        sb.append("+\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                } else {
                    int n = stack.pop();
                    if (n > picked){
                        result = false;
                        System.out.println("NO");
                        break;
                    } else {
                        sb.append("-\n");
                    }
                }
            }

            if (result){
                System.out.println(sb.toString());
            }
        }
    }

    public static class BOJ2164{
        // N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다.
        // 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다.
        // 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다.
        // 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int target = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= target; i++) {
                queue.offer(i);
            }

            while (queue.size() > 1){
                queue.poll();
                Integer toPush = queue.poll();
                queue.offer(toPush);
            }

            System.out.println(queue.poll());
        }
    }

    // TODO: 2023/05/31 11286 

    public class BOJ11286 {
        // heap, priority queue
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int initialCapacity = sc.nextInt();

            class Number implements Comparable<Number> {
                int value;
                int absValue;

                public Number(int value) {
                    this.value = value;
                    this.absValue = Math.abs(value);
                }

                @Override
                public int compareTo(Number o) {
                    // 절댓값을 기준으로 오름차순 정렬
                    if (this.absValue == o.absValue) {
                        // 절댓값이 같은 경우 원래 숫자를 기준으로 오름차순 정렬
                        return Integer.compare(this.value, o.value);
                    } else {
                        return Integer.compare(this.absValue, o.absValue);
                    }
                }
            }

            Number[] arr = new Number[initialCapacity];

            for (int i = 0; i < initialCapacity; i++) {
                arr[i] = new Number(sc.nextInt());
            }

            PriorityQueue<Number> pq = new PriorityQueue<>(initialCapacity);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].value == 0) {
                    if (pq.isEmpty()) {
                        sb.append("0\n");
                    } else {
                        Number poll = pq.poll();
                        sb.append(poll.value).append("\n");
                    }
                } else {
                    pq.add(arr[i]);
                }
            }

            System.out.println(sb.toString());
        }
    }

}
