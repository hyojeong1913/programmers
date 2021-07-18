public class Main {
    
    public static void main(String[] args) {

        String[] arr = {
            "one4seveneight",
            "23four5six7",
            "2three45sixseven",
            "123"
        };

        for (int i=0; i<arr.length; i++) {
            System.out.println(solution(arr[i]));
        }
    }

    public static int solution(String s) {
        
        int answer = 0;
        
        String[] numStr = {
            "zero", "one", "two", "three", "four", "five", 
            "six", "seven", "eight", "nine"
        };
        
        // 문자열을 숫자로 변환
        for (int i=0; i<numStr.length; i++) {
            s = s.replace(numStr[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
