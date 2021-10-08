public class Main {

    public static void main(String[] args) {

        String[] str = {
            "pPoooyY",
            "Pyy"
        };

        for (int i=0; i<str.length; i++) {
            System.out.println(solution(str[i]));
        }
    }
    
    public static boolean solution(String s) {
        
        boolean answer = true;

        s = s.toLowerCase();
        
        String p_str = s.replaceAll("p", "");
        String y_str = s.replaceAll("y", "");
        
        if (p_str.length() == y_str.length()) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}