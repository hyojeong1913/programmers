public class Main {
    
    public static void main(String[] args) {
        
        int nums[] = {123, 987};

        for (int i=0; i<nums.length; i++) {
            System.out.println(solution(nums[i]));
        }
    }

    public static int solution(int n) {
        
        int answer = 0;
        
        String tmp = "" + n;
        
        for (int i=0; i<tmp.length(); i++) {
            answer += (tmp.charAt(i) - '0');
        }

        return answer;
    }
}
