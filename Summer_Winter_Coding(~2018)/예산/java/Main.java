import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[][] d = {
            {1, 3, 2, 5, 4},
            {2, 2, 3, 3}
        };

        int[] budget = {
            9, 10
        };

        for (int i=0; i<d.length; i++) {
            System.out.println(solution(d[i], budget[i]));
        }
    }

    public static int solution(int[] d, int budget) {
        
        int answer = 0;
        
        // 부서 신청금액 오름차순으로 정렬
        Arrays.sort(d);
    
        for (int i=0; i<d.length; i++) {
            // 예산이 부서 신청금액보다 적은 경우 반복문 탈출
            if (d[i] > budget) {
                break;
            }
            
            budget -= d[i];
            answer++;
        }
        
        return answer;
    }
}
