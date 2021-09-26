import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) {

        int[][] answers = {
            {1, 2, 3, 4, 5},
            {1, 3, 2, 4, 2}
        };

        for (int i=0; i<answers.length; i++) {
            System.out.println(Arrays.toString(solution(answers[i])));
        }
    }

    public static Integer[] solution(int[] answers) {
        
        int[] cnt = {0, 0, 0};
        
        int[] aWay = {1, 2, 3, 4, 5};
        int[] bWay = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cWay = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i=0; i<answers.length; i++) {
        
            if (answers[i] == aWay[i % aWay.length]) {
                cnt[0]++;    
            }
            
            if (answers[i] == bWay[i % bWay.length]) {
                cnt[1]++;
            }
            
            if (answers[i] == cWay[i % cWay.length]) {
                cnt[2]++;
            }
        }
        
        int winScore = cnt[0];
    
        // 1등 점수 확인
        for (int i=0; i<cnt.length; i++) {
            
            if (winScore < cnt[i]) {
                winScore = cnt[i];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
    
        // 1등이 누구인지 확인
        for (int i=0; i<cnt.length; i++) {

            if (winScore == cnt[i]) {
                result.add(i + 1);
            }
        }
        
        // 1등이 여러 명일 경우 정렬
        Collections.sort(result);
    
        return result.toArray(new Integer[result.size()]);
    }
}