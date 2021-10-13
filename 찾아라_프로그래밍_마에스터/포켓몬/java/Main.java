import java.util.HashSet;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    
        int[][] nums = {
            {3, 1, 2, 3},
            {3, 3, 3, 2, 2, 4},
            {3, 3, 3, 2, 2, 2}
        };

        for (int i=0; i<nums.length; i++) {
            System.out.println(solution(nums[i]));
        }
    }

    public static int solution(int[] nums) {
        
        int answer = 0;
        
        HashSet<Integer> nums_set = new HashSet<>();
        
        for (int i=0; i<nums.length; i++) {
            
            if (!nums_set.contains(nums[i])) {
                nums_set.add(nums[i]);   
            }
        }
        
        // 절반의 개수
        int half = nums.length / 2;

        // 종류 개수
        int types = nums_set.size();
        
        if (half >= types) {
            answer = types;
        } else {
            answer = half;
        }
        
        return answer;
    }
}
