public class Main {
    
    public static void main(String[] args) {

        int n = 15;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        
        int answer = 0;
        int sum = 0;
        
        for (int i=1; i<=n; i++) {
            
            sum = 0;
            
            for (int j=i; j<=n; j++) {
                
                sum += j;
                
                if (sum > n) {
                    break;
                }
                
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
