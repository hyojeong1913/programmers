import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        String[] s = {
            "110010101001",
            "01110",
            "1111111"
        };

        for (int i=0; i<s.length; i++) {
            System.out.println(Arrays.toString(solution(s[i])));
        }
    }

    public static int[] solution(String s) {
        
        int[] answer = new int[2];
        
        int cnt = 0;
        int cnt_0 = 0;
        
        int before_len = 0;
        int after_len = 0;
        
        while (!s.equals("1")) {
            
            // 이진 변환 횟수 누적
            cnt++;
            
            // 모든 0 제거 전 문자열 길이
            before_len = s.length();

            // 모든 0 제거
            s = s.replaceAll("0", "");

            // 모든 0 제거 후 문자열 길이
            after_len = s.length();
            
            // 제거된 0의 개수
            cnt_0 += (before_len - after_len);
            
            // 2진수로 변환
            s = Integer.toBinaryString(after_len);
        }
        
        answer[0] = cnt;
        answer[1] = cnt_0;
        
        return answer;
    }
}
