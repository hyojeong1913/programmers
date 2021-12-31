import java.util.Arrays;
import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) {

        String[] str = {
            "Enter uid1234 Muzi", 
            "Enter uid4567 Prodo", 
            "Leave uid1234", 
            "Enter uid1234 Prodo", 
            "Change uid4567 Ryan"
        };

        System.out.println(Arrays.toString(solution(str)));
    }

    public static String[] solution(String[] record) {
        
        HashMap<String, String> userInfo = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<record.length; i++) {
            
            String[] arr = record[i].split(" ");
            
            switch (arr[0]) {
                case "Enter":
                    sb.append(arr[1]).append("님이 들어왔습니다.&");
                    userInfo.put(arr[1], arr[2]);
                    break;
                case "Leave":
                    sb.append(arr[1]).append("님이 나갔습니다.&");
                    break;
                case "Change":
                    userInfo.put(arr[1], arr[2]);
                    break;
            }
        }
        
        String[] answer = sb.toString().split("&");
        
        for (int i=0; i<answer.length; i++) {
            
            String nickname = answer[i].substring(0, answer[i].indexOf("님"));
            
            answer[i] = answer[i].replace(nickname, userInfo.get(nickname));
        }
        
        return answer;
    }
}
