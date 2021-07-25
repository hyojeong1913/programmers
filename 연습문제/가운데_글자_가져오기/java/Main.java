public class Main {

    public static void main(String[] args) {

        String[] input = {"abcde", "qwer"};

        for (int i=0; i<input.length; i++) {
            System.out.println(solution(input[i]));
        }
    }

    public static String solution(String s) {
        
        String answer = "";
        
        int index = s.length() / 2;
        
        if (s.length() % 2 == 0) {
            answer = s.substring(index - 1, index + 1);
        } else {
            answer = Character.toString(s.charAt(index));
        }
        
        return answer;
    }
}
