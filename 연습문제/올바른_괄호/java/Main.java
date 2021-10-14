import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String[] s = {
            "()()",
            "(())()",
            ")()(",
            "(()("
        };

        for (int i=0; i<s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    static boolean solution(String s) {
        
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            
            char str = s.charAt(i);
            
            // 여는 괄호 '(' 차례인 경우
            if (str == '(') {
                stack.push('(');
            } 
            // 닫는 괄호 ')' 차례인 경우
            else {
                
                // 스택이 비어있다면 무조건 false 리턴
                if (stack.isEmpty()) {
                    return false;
                } 
                // 여는 괄호 '(' 가 아직 남아있는 경우 pop
                else {
                    stack.pop();
                }
            }
        }
        
        if (stack.size() == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}
