public class Main {

    public static void main(String[] args) {

        int[] n = {10, 5};

        for (int i=0; i<n.length; i++) {

            System.out.println(solution(n[i]));
        }
    }

    public static int solution(int n) {
        
        int answer = 0;
        
        for (int i=2; i<=n; i++) {
            
            if (isPrime(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    /**
     * 소수 찾기
     * 
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        
        if (num % 2 == 0) {
            
            if (num == 2) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            
            if (num == 1) {
                return false;
            }
            
            for (int i=3; i<=(int)Math.sqrt(num); i=i+2) {
                
                if (num % i == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
