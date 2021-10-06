import java.util.Stack;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[][] arr = {
            {1, 1, 3, 3, 0, 1, 1},
            {4, 4, 4, 3, 3}
        };

        for (int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(solution(arr[i])));
        }
    }

    public static Object[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<arr.length; i++) {
            
            // 스택이 비어있다면
            if (stack.isEmpty()) {
                
                // 스택에 숫자 삽입
                stack.push(arr[i]);
            }
            // 해당 숫자가 스택 마지막 숫자와 다른 경우
            else if (stack.peek() != arr[i]) {
                
                // 스택에 숫자 삽입
                stack.push(arr[i]);
            }
        }
        
        return stack.toArray();
    }
}
