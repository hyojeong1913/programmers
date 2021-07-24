import java.util.Arrays;

public class Main {
   
    public static void main(String[] args) {
    
        // 참가자 명단
        String[][] participant = {
            {"leo", "kiki", "eden"},
            {"marina", "josipa", "nikola", "vinko", "filipa"},
            {"mislav", "stanko", "mislav", "ana"}
        };

        // 완주자 명단
        String[][] completion = {
            {"eden", "kiki"},
            {"josipa", "filipa", "marina", "nikola"},
            {"stanko", "ana", "mislav"}
        };

        for (int i=0; i<participant.length; i++) {
            System.out.println(solution(participant[i], completion[i]));
        }
    } 

    public static String solution(String[] participant, String[] completion) {

        // 보다 쉬운 비교를 위해 오름차순으로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i;
        
        // 순서가 다른 이름이 존재하는 경우 바로 미완주자로 리턴
        for (i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                return participant[i];
        }
        
        // 마지막 순서 전까지 완주자 명단에 있으므로 마지막 참가자를 미완주자로 리턴
        return participant[i];
    }
}
