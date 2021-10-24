public class Main {

    public static void main(String[] args) {

        int[] num = {10, 12};

        for (int i=0; i<num.length; i++) {
            System.out.println(solution(num[i]));
        }
    }
    
    public static int solution(int n) {
        
        int answer = 0;
        
        // n - 1 이 짝수인 경우 바로 2 리턴
        if ((n - 1) % 2 == 0) {
            answer = 2;
        } 
        // n - 1 이 홀수인 경우
        else {

            // n - 1 의 약수 중 2를 제외한 가장 작은 수 리턴
            answer = getMinDivisor(n - 1);
        }
        
        return answer;
    }
    
    /**
     * 약수 중 2를 제외한 가장 작은 수 구하기
     * 
     * @param n
     * @return
     */
    public static int getMinDivisor(int n) {
        
        int answer = 0;
        
        for (int i=3; i<=n; i++) {
            
            if (n % i == 0) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
