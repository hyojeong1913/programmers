import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        String[] str = {
            "{{2},{2,1},{2,1,3},{2,1,3,4}}",
            "{{1,2,3},{2,1},{1,2,4,3},{2}}",
            "{{20,111},{111}}",
            "{{123}}",
            "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        };

        for (int i=0; i<str.length; i++) {
            
            System.out.println(solution(str[i]));
        }
    }
    
    public static ArrayList<Integer> solution(String s) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        s = s.substring(2, s.length() - 2);
        
        String[] sArr = s.split("\\},\\{");
        
        Arrays.sort(sArr, new Comparator<String>() {
            
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        
        for (int i=0; i<sArr.length; i++) {
            
            String[] tmp = sArr[i].split(",");
            
            for (int j=0; j<tmp.length; j++) {
                
                int num = Integer.parseInt(tmp[j]);
                
                if (!answer.contains(num)) {
                    
                    answer.add(num);
                }
            }
        }
        
        return answer;
    }
}
