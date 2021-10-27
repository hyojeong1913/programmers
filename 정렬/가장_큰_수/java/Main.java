import java.util.Arrays;
import java.util.Comparator;

public class Main {
    
    public static void main(String[] args) {

        int[][] numbers = {
            {6, 10, 2},
            {3, 30, 34, 5, 9}
        };

        for (int i=0; i<numbers.length; i++) {
            System.out.println(solution(numbers[i]));
        }
    }

    public static String solution(int[] numbers) {
        
        String answer = "";
        
        String[] numStr = new String[numbers.length];
        
        // 숫자 배열을 문자열 배열로 변환
        for (int i=0; i<numbers.length; i++) {
            
            numStr[i] = numbers[i] + "";
        }
        
        // 문자열 2개를 더하여 더 큰 쪽을 우선순위로 하는 정렬 규칙 재정의
        Arrays.sort(numStr, new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2) {
                
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        // 맨 앞글자가 0인 경우 (0000....000) 0으로 리턴
        if (numStr[0].equals("0")) {
            answer = "0";
        }
        // 문자열로 순차적으로 연결하여 리턴
        else {
            answer = String.join("", numStr);
        }
        
        return answer;
    }
}
