import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        String[][] strings = {
            {"sun", "bed", "car"},
            {"abce", "abcd", "cdx"}
        };

        int[] n = {1, 2};

        for (int i=0; i<n.length; i++) {
            System.out.println(Arrays.toString(solution(strings[i], n[i])));
        }
    }

    public static String[] solution(String[] strings, int n) {
        
        ArrayList<String> list = new ArrayList<>();
        
        for (int i=0; i<strings.length; i++) {
            
            list.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(list);
        
        String[] answer = new String[strings.length];
        
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).substring(1, list.get(i).length());
        }
        
        return answer;
    }
}
