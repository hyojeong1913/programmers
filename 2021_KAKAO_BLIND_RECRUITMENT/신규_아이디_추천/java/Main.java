public class Main {

    public static void main(String[] args) {

        String[] arr = {
            "...!@BaT#*..y.abcdefghijklm",
            "z-+.^.",
            "=.=",
            "123_.def",
            "abcdefghijklmn.p",
        };

        for (int i=0; i<arr.length; i++) {
            System.out.println(solution(arr[i]));
        }
    }

    public static String solution(String new_id) {
        // 정답
        String answer = "";
        
        // 1단계
        answer = new_id.toLowerCase();
        
        // 2단계
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계
        if (answer.length() == 0) {
            answer = "a";
        }
        
        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }
        
        // 7단계
        if (answer.length() <= 2) {
            char last = answer.charAt(answer.length() - 1);
            
            int index = answer.length();
            
            do {
                answer += last;
                index++;
            } while (index < 3);
        }
        
        return answer;
    }
}