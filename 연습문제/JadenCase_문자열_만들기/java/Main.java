public class Main {

    public static void main(String[] args) {

        String[] s = {
            "3people unFollowed me",
            "for the last week"
        };

        for (int i=0; i<s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    public static String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        
        // 모두 소문자로 초기화
        s = s.toLowerCase();
        
        for (int i=0; i<s.length(); i++) {
            
            char str = s.charAt(i);
            
            // 공백 후 첫 글자는 대문자로
            if (index == 0) {
                str = Character.toUpperCase(str);
            }
            
            sb.append(str);
            
            index++;
            
            // 단어 첫글자를 알아내기 위해 공백인 경우 인덱스 0으로 초기화
            if (str == ' ') {
                index = 0;
            }
        }
        
        return sb.toString();
    }
}