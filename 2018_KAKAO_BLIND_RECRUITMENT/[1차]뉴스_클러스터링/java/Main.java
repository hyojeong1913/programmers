import java.util.ArrayList;
import java.util.Collections;

public class Main {
 
    public static void main(String[] args) {

        String[] str1 = { "FRANCE", "handshake", "aa1+aa2", "E=M*C^2" };
        String[] str2 = { "french", "shake hands", "AAAA12", "e=m*c^2" };

        for (int i=0; i<str1.length; i++) {

            System.out.println(solution(str1[i], str2[i]));
        }
    }

    public static int solution(String str1, String str2) {
        
        int answer = 0;
        
        // 두 문자열 모두 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 두 글자씩 끊어서 다중집합 구하기
        ArrayList<String> list1 = getList(str1);
        ArrayList<String> list2 = getList(str2);
        
        // 교집합
        ArrayList<String> intersection = new ArrayList<>();

        // 합집합
        ArrayList<String> union = new ArrayList<>();
        
        // 중복 처리를 위해 정렬
        Collections.sort(list1);
        Collections.sort(list2);
        
        // 교집합 구하기
        for (int i=0; i<list1.size(); i++) {
            
            String tmp = list1.get(i);
            
            if (list2.contains(tmp)) {
                
                list2.remove(tmp);
                intersection.add(tmp);
            }
            
            // 합집합에도 추가
            union.add(tmp);
        }
        
        // 남은 합집합 구하기
        for (int i=0; i<list2.size(); i++) {
            
            union.add(list2.get(i));
        }
        
        // 두 집합이 모두 공집합으로 합집합이 없는 경우
        if (union.size() == 0) {

            // 1 * 65536
            answer = 65536;
        }
        else {
            
            // 자카드 유사도 (교집합 / 합집합) * 65536
            answer = (int) ((double) intersection.size() / (double) union.size() * 65536);
        }
        
        return answer;
    }
    
    /**
     * 두 글자씩 끊어서 다중집합 구하기
     * 
     * @param str
     * @return
     */
    public static ArrayList<String> getList(String str) {
        
        ArrayList<String> list = new ArrayList<>();
        
        for (int i=0; i<str.length()-1; i++) {
            
            char s1 = str.charAt(i);
            char s2 = str.charAt(i + 1);
            
            // 문자인 경우에만 추가
            if (Character.isLetter(s1) && Character.isLetter(s2)) {
                
                list.add(Character.toString(s1) + Character.toString(s2));
            }
        }
        
        return list;
    }
}
