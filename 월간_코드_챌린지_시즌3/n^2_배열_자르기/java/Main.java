import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[] n = {3, 4};
        int[] left = {2, 7};
        int[] right = {5, 14};

        for (int i=0; i<n.length; i++) {
            
            System.out.println(Arrays.toString(solution((long) n[i], (long) left[i], (long) right[i])));
        }
    }

    public static Long[] solution(long n, long left, long right) {
        
        ArrayList<Long> answer = new ArrayList<>();
        
        for (Long i=left; i<=right; i++) {
            
            // 행과 열의 최댓값 + 1
            answer.add(Math.max(i / n, i % n) + 1);
        }
        
        return answer.toArray(new Long[answer.size()]);
    }
}
