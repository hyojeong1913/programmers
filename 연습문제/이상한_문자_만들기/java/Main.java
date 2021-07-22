public class Main {

    public static void main(String[] args) {

        String str = "try hello world";

        System.out.println(solution(str));
    }

    public static String solution(String s) {
        String answer = "";
        
        int index = 0;
        
        // 일단 모두 소문자로 변경
        s = s.toLowerCase();
        
        for (int i=0; i<s.length(); i++) {
            
            char tmp = s.charAt(i);
            
            // 공백인 경우
            if (tmp == ' ') {
                // 단어 기준으로 구분하기 위해 인덱스 값 초기화
                index = -1;
                answer += ' ';
            } else {
                // 짝수 인덱스인 경우
                if (index % 2 == 0) {
                    // 소문자로 대체
                    answer += (char)(tmp - 32);
                } else {
                    answer += tmp;
                }
            }
            
            index++;
        }
        
        return answer;
    }
}
