import java.util.HashMap;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] n = {3, 5, 2};

        String[][] words = {
            {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
            {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
            {"hello", "one", "even", "never", "now", "world", "draw"}
        };

        for (int i=0; i<n.length; i++) {
            System.out.println(Arrays.toString(solution(n[i], words[i])));
        }
    }

    public static int[] solution(int n, String[] words) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int who = 0;
        int cnt = 0;
        
        map.put(words[0], 0);

        for (int i=1; i<words.length; i++) {
            
            if (map.get(words[i]) != null || !words[i - 1].endsWith(words[i].substring(0, 1))) {

                who = (i % n) + 1;
                cnt = (i / n) + 1;
    				
                break;
    		}
                
            map.put(words[i], i);
        }
        
        return new int[]{who, cnt};
    }
}