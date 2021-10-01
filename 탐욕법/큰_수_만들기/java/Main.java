import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {

        String[] numbers = {
            "1924",
            "1231234",
            "4177252841"
        };

        int[] k = {2, 3, 4};

        for (int i=0; i<numbers.length; i++) {
            System.out.println(solution(numbers[i], k[i]));
        }
    }
    
    public static String solution(String number, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        
        int len = number.length() - k;
        
        for (int i=0; i<number.length(); i++) {
            
            Character tmp = number.charAt(i);
            
            // 스택이 비어있다면
            if (stack.isEmpty()) {
                
                // 스택에 숫자 삽입
                stack.push(tmp);
            }
            // 스택이 비어있지 않다면
            else {
                // 해당 숫자가 스택 최상위 숫자 이상인 경우
                if (stack.peek() >= tmp) {

                    // 스택에 숫자 삽입
                    stack.push(tmp);
                }
                // 해당 숫자가 스택 최상위 숫자보다 작은 경우
                else {
                    
                    // 스택이 비어있지 않고, 스택 최상위 숫자가 해당 숫자보다 작고, 지워야 하는 개수가 0보다 클 때까지
                    while (!stack.isEmpty() && stack.peek() < tmp && k > 0) {

                        // 스택에 있는 최상위 숫자 뺀다.
                        stack.pop();

                        // 지워야 하는 개수 1 감소
                        k--;
                    }
                    
                    // 해당 숫자 스택에 삽입
                    stack.push(tmp);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().substring(0, len).toString();
    }
}
