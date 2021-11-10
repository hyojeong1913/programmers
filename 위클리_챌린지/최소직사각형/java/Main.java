import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    
    public static void main(String[] args) {

        int[][] sizes1 = {
            {60, 50}, 
            {30, 70},
            {60, 30},
            {80, 40}
        };

        int[][] sizes2 = {
            {10, 7}, 
            {12, 3},
            {8, 15},
            {14, 7},
            {5, 15}
        };

        int[][] sizes3 = {
            {14, 4}, 
            {19, 6},
            {6, 16},
            {18, 7},
            {7, 11}
        };

        System.out.println(solution(sizes1));
        System.out.println(solution(sizes2));
        System.out.println(solution(sizes3));
    }

    public static int solution(int[][] sizes) {
        
        int answer = 0;
        
        ArrayList<Integer> longs = new ArrayList<>();
        ArrayList<Integer> shorts = new ArrayList<>();
        
        for (int i=0; i<sizes.length; i++) {
            
            int len1 = sizes[i][0];
            int len2 = sizes[i][1];
            
            if (len1 > len2) {
                
                longs.add(len1);
                shorts.add(len2);
            }
            else {
                
                longs.add(len2);
                shorts.add(len1);
            }
        }
        
        longs.sort(Comparator.reverseOrder());
        shorts.sort(Comparator.reverseOrder());
        
        answer = longs.get(0) * shorts.get(0);
        
        return answer;
    }
}
