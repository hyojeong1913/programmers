public class Main {

    public static void main(String[] args) {

        String[] s = {
            "aabbaccc",
            "ababcdcdababcdcd",
            "abcabcdede",
            "abcabcabcabcdededededede",
            "xababcdcdababcdcd"
        };

        for (int i=0; i<s.length; i++) {

            System.out.println(solution(s[i]));
        }
    }

    public static int solution(String s) {
        
        int len = s.length();
        int answer = len;
        
        if (len == 1) {
            
            return 1;
        }
        
        // 입력받은 문자열 길이 / 2 만큼 압축이 가능
        for (int i=1; i<=len/2; i++) {
            
            // 압축한 각 문자열 개수
            int cnt = 1;
            
            // 압축 후 담은 문자열
            String str = "";

            // 비교할 자른 문자열
            String tmp = "";
            
            for (int j=0; j<len/i; j++) {
                
                // 직전에 자른 문자열과 현재 자른 문자열이 같은 경우
                if (tmp.equals(s.substring(i * j, (i * j) + i))) {
                    
                    // 문자열 개수 1 누적
                    cnt++;
                    continue;
                }
                
                // 누적된 개수가 1 보다 큰 경우
                if (cnt > 1) {
                    
                    // 개수와 함께 문자열에 담는다.
                    str += cnt + tmp;
                    
                    // 다시 문자열 개수 리셋
                    cnt = 1;
                }
                else {
                    
                    // 나머지는 자른 문자열만 문자열에 담는다.
                    str += tmp;
                }
                
                // 현재 자른 문자열로 비교 대상 대체
                tmp = s.substring(i * j, (i * j) + i);
            }
            
            // 담지 못하고 남은 문자열 처리
            if (cnt > 1) {
                    
                str += cnt + tmp;

                cnt = 1;
            }
            else {

                str += tmp;
            }
            
            if (len % i != 0) {
                
                str += s.substring(len - len % i, len);
            }
            
            // 최솟값의 길이 찾기
            if (answer > str.length()) {
                
                answer = str.length();
            }
        }
        
        return answer;
    }
}
