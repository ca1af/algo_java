import java.util.*;

public class Sol0411 {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        // 캘린더 객체의 달은 0부터 시작함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        return days[dayOfWeek - 1];
    }


    public String solution1(String[] cards1, String[] cards2, String[] goal) {
        // 순서대로 나와야 하므로 큐 사용해야 할듯.

        LinkedList<String> card1 = new LinkedList<>();
        LinkedList<String> card2 = new LinkedList<>();

        Collections.addAll(card1, cards1);
        Collections.addAll(card2, cards2);

        for (int i = 0; i < goal.length; i++) {
            if (Objects.equals(card1.get(i), goal[i])) {
                card1.remove(i);
            } else if (card2.get(i).equals(goal[i])) {
                card2.remove(i);
            }
        }

        String answer = "";
        return answer;
    }

    // String 배열을 역순으로 만드는 메소드
    public static void reverseArray(String[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // String 배열을 스택으로 만드는 메소드
    public static Stack<String> arrayToStack(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String str : arr) {
            stack.push(str);
        }
        return stack;
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        reverseArray(cards1);
        reverseArray(cards2);

        Stack<String> stack1 = arrayToStack(cards1);
        Stack<String> stack2 = arrayToStack(cards2);

        String answer = "Yes";

        for (String s : goal) {
            if (stack1.peek().equals(s)){
                stack1.pop();
            } else if (stack2.peek().equals(s)){
                stack2.pop();
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }


    public int[] solution1(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;

        //  합의 약수 중 중간값(이거나 중간값들)
        // 9 1,3,9 <
        // 48 -> 1,2,4,6,8,12,24,48 딱 중간두놈이네

        List<Integer> integers = new LinkedList<>();

        for (int i = 1; i < total; i++) {
            if (total % i == 0){
                integers.add(i);
            }
        }
        System.out.println(integers);

        int z = integers.size() % 2;

        if (z == 0){
            answer = new int[]{integers.get(z - 1), integers.get(z)};
        } else {
            answer = new int[]{z-integers.get(z - 1), z-integers.get(z - 1)};
        }

        return answer;
    }

    public int[] solution2(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {
                int width = total / height;

                int brownCnt = (width + height) * 2 - 4;
                if (brownCnt == brown) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }

    // 콜라문제
    public static int solution(int a, int b, int n) {
        // 관건은, 나머지로 남은 병을 어떻게 처리 할 것이냐?
        int answer = 0;
        int exchange = n / a;

        // n이 1보다 클 경우에만 계산
        while (n > 1){
            answer += exchange;
            n = exchange + n % a;
            exchange = n / a;
        }

        return answer;
    }
    public static void main(String[] args) {
        int solution = solution(2, 1, 20);
        System.out.println(solution);
        System.out.println(20/2);
    }


}
