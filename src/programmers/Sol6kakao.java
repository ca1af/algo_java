package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//정수 배열 numbers가 주어집니다.
// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록
// solution 함수를 완성해주세요.

public class Sol6kakao {
    public int solution(int[] nums) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || stack.peek() != nums[i]){
                stack.push(nums[i]);
            }
        }
        int size = stack.size();
        if (stack.size() >= nums.length/2){
            size = nums.length / 2;
        }
        return size;
    }

    public int solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int half = nums.length / 2;
        return Math.min(set.size(), half);
    }
}
