import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {

        String[] p = {
            "(()())()",
            ")(",
            "()))((()"
        };

        for (int i=0; i<p.length; i++) {

            System.out.println(solution(p[i]));
        }
    }

    public static String solution(String p) {
        
        if (isCorrect(p)) {
            return p;
        }
        
        return convert(p);
    }
    
    /**
     * 올바른 괄호인지 변환
     * 
     * @param str
     * @return
     */
    public static String convert(String str) {
        
        if (str.equals("")) {
            return "";
        }
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        int cnt = 0;
        
        for (int i=0; i<str.length(); i++) {
            
            char ch = str.charAt(i);
            
            if (ch == '(') {
                cnt++;
            }
            else {
                cnt--;
            }
            
            if (cnt == 0) {
                
                u.append(str.substring(0, i + 1));
                v.append(str.substring(i + 1));
                
                break;
            }
        }
        
        if (isCorrect(u.toString())) {
                    
            u.append(convert(v.toString()));
        }
        else {

            StringBuilder tmp = new StringBuilder();

            tmp.append("(");
            tmp.append(convert(v.toString()));
            tmp.append(")");

            String uStr = u.toString();

            uStr = uStr.substring(1, uStr.length() - 1);
            uStr = uStr.replace("(", ".");
            uStr = uStr.replace(")", "(");
            uStr = uStr.replace(".", ")");

            tmp.append(uStr);

            return tmp.toString();
        }
        
        return u.toString();
    }
    
    /**
     * 올바른 괄호인지 체크
     * 
     * @param str
     * @return
     */
    public static boolean isCorrect(String str) {
        
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<str.length(); i++) {
            
            char ch = str.charAt(i);
            
            if (ch == '(') {
                stack.push('(');
            }
            else {
                
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        
        if (stack.size() == 0) {

            answer = true;
        }
        else {

            answer = false;
        }
        
        return answer;
    }
}
