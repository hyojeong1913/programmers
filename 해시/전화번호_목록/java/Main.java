import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String[][] phone_book = {
            {"119", "97674223", "1195524421"},
            {"123", "456", "789"},
            {"12", "123", "1235", "567", "88"}
        };

        for (int i=0; i<phone_book.length; i++) {
            System.out.println(solution(phone_book[i]));
        }
    }

    public static boolean solution(String[] phone_book) {
        
        boolean answer = true;
        
        Map<String, String> map = new HashMap<>();
        
        Arrays.sort(phone_book);
        
        // 모든 전화번호 HashMap 에 추가
        for (int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i]);
        }
        
        // 전화번호의 접두어가 HashMap 에 있는지 확인
        for (int i=0; i<phone_book.length; i++) {
            
            for (int j=0; j<phone_book[i].length(); j++) {
                
                String tmp = phone_book[i].substring(0, j);
                
                if (map.containsKey(tmp)) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}
