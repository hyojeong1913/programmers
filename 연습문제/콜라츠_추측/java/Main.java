package 연습문제.콜라츠_추측.java;

public class Main {
    
    public static void main(String[] args) {

        long[] n = {6, 16, 626331};

        for (int i=0; i<n.length; i++) {

            System.out.println(solution(n[i]));
        }
    }

    public static int solution(long num) {
        
        int answer = 0;
        
        while (num != 1) {
            
            // 짝수인 경우
            if (num % 2 == 0) {
                
                num /= 2;
            }
            // 홀수인 경우
            else {
                
                num = (num * 3) + 1;
            }
            
            answer++;
            
            if (answer == 500) {
                
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}
