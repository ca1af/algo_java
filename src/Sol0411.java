import java.util.*;

public class Sol0411 {
    public String solution(int a, int b) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        // 캘린더 객체의 달은 0부터 시작함

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        // 인덱스이므로 -1
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

}
