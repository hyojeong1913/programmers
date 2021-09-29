import java.util.HashMap;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
    
        String[][] clothesA = {
            {"yellowhat", "headgear"},
            {"bluesunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };

        String[][] clothesB = {
            {"crowmask", "face"},
            {"bluesunglasses", "face"},
            {"smoky_makeup", "face"}
        };

        System.out.println(solution(clothesA));
        System.out.println(solution(clothesB));
    }
    
    public static int solution(String[][] clothes) {
        
        int answer = 1;
        
        HashMap<String,Integer> clothesMap = new HashMap<String,Integer>();
        
        for (int i=0; i<clothes.length; i++) {
            
            String key = clothes[i][1];
            
            // 옷 종류가 hashMap 에 이미 존재하는 경우
            if (clothesMap.containsKey(key)) {
                
                // 해당 옷 개수 조회
                int cnt = clothesMap.get(key);
                
                // 개수 1 증가하여 저장
                clothesMap.put(key, ++cnt);
            }
            // 옷 종류가 hashMap 에 존재하지 않는 경우 
            else {
                // 1로 개수 초기화하여 hashMap 에 추가
                clothesMap.put(key, 1);
            }
        }
        
        Collection<Integer> values = clothesMap.values();
        
        // 경우의 수를 구하기 위해 각 개수에 1을 더한 뒤 곱해준다.
        for (int value : values) {
            answer *= (value + 1);
        }
        
        // 아무것도 안 입었을 경우를 빼 준다.
        answer -= 1;
        
        return answer;
    }
}
