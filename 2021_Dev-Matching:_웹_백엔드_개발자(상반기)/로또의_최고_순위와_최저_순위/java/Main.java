import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    
    public static void main(String[] args) {

        int[][] lottos = {
            {44, 1, 0, 0, 31, 25},
            {0, 0, 0, 0, 0, 0},
            {45, 4, 35, 20, 3, 9}
        };

        int[][] win_nums = {
            {31, 10, 45, 1, 6, 19},
            {38, 19, 20, 40, 15, 25},
            {20, 9, 3, 45, 4, 35}
        };

        for (int i=0; i<lottos.length; i++) {
            System.out.println(Arrays.toString(solution(lottos[i], win_nums[i])));
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = {0, 0};
        
        int cnt_match = 0; // 일치 개수
        int cnt_zero = 0; // 0 의 개수
        
        for (int i=0; i<lottos.length; i++) {
            
            final int num = lottos[i];
            
            if (num == 0) {
                cnt_zero++;
            } else {
                // 해당 숫자가 당첨 배열에 포함되는지 확인
                if (IntStream.of(win_nums).anyMatch(x -> x == num)) {
                    cnt_match++;
                }   
            }
        }
        
        answer[0] = getRank(cnt_match + cnt_zero);
        answer[1] = getRank(cnt_match);
        
        return answer;
    }
    
    /**
     * 일치 개수로 해당 순위 조회
     * 
     * @param cnt
     * @return
     */
    public static int getRank(int cnt) {
        
        int rank = 6;
        
        switch (cnt) {
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank = 6;
                break;
        }
        
        return rank;
    }
}
