import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        String[] str = {"baabaa", "cdcd"};

        for (int i=0; i<str.length; i++) {
            System.out.println(solution(str[i]));
        }
    }

    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            
            char tmp = s.charAt(i);
            
            // 스택이 비어있지 않고, 해당 문자와 최근 스택에 넣은 숫자가 같은 경우
            if (!stack.isEmpty() && stack.peek() == tmp) {

                // 스택에 들어있는 문자 제거
                stack.pop();

            }
            // 스택이 비어있거나 해당 문자와 최근 스택에 넣은 숫자가 다른 경우
            else {

                // 스택에 해당 문자 추가
                stack.push(tmp);
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
