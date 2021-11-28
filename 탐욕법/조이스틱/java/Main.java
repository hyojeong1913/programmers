public class Main {

    public static void main(String[] args) {

        String[] names = {
            "JEROEN",
            "JAN"
        };

        for (int i=0; i<names.length; i++) {

            System.out.println(solution(names[i]));
        }
    }

    public static int solution(String name) {
        
        int answer = 0;
        
        int length = name.length();
        int min = length - 1;
        
        for (int i=0; i<length; i++) {
            
            char ch = name.charAt(i);
            
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
            
            int nextIndex = i + 1;
            
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {

                nextIndex++;
            }
            
            min = Math.min(min, i + length - nextIndex + i);
        }
        
        answer += min;
        
        return answer;
    }
}
