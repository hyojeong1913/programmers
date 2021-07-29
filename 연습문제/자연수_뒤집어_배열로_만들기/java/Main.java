import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        long n = 12345;

        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(long n) {
        
        // 자릿수 알아내기 쉽게 문자열로 변환
        String tmp = "" + n;
        
        int[] answer = new int[tmp.length()];
        
        int index = 0;
        
        // 각 자리 숫자 배열에 담기
        while (n > 0) {
            answer[index] = (int) (n % 10);
            n /= 10;
            index++;
        }
        
        return answer;
    }
}
