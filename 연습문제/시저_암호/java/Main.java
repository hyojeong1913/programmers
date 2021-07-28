public class Main {
    
    public static void main(String[] args) {
    
        String[] str = {"AB", "z", "a B z"};
        int[] n = {1, 1, 4};

        for (int i=0; i<str.length; i++) {
            System.out.println(solution(str[i], n[i]));
        }
    }

    public static String solution(String s, int n) {
        
        String answer = "";
        
        for (int i=0; i<s.length(); i++) {
            
            // 각 자리의 알파벳
            char alpha = s.charAt(i);
            
            // 공백인 경우 공백 그대로 출력
            if (alpha == ' ') {
                answer += ' ';
            } else {
                // 해당 알파벳의 아스키 코드
                int ascii = (int) s.charAt(i);
                int start = 0;
                
                if (ascii >= 65 && ascii <= 90) { // 대문자인 경우
                    start = 65;
                } else if (ascii >= 97 && ascii <= 122) { // 소문자인 경우
                    start = 97;
                }
                
                // 자릿수 이동
                ascii = (ascii + n - start) % 26 + start;
                
                // 다시 알파벳으로 변환
                answer += (char) ascii;
            }
        }
        
        return answer;
    }
}