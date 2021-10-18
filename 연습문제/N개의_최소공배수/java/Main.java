public class Main {
    
    public static void main(String[] args) {

        int[][] arr = {
            {2, 6, 8, 14},
            {1, 2, 3}
        };

        for (int i=0; i<arr.length; i++) {
            System.out.println(solution(arr[i]));
        }
    }

    public static int solution(int[] arr) {
        
        int answer = arr[0];
        
        for (int i=0; i<arr.length; i++) {
            
            for (int j=i+1; j<arr.length; j++) {
                
                answer = lcm(answer, arr[j]);
            }
        }
        
        return answer;
    }
    
    /**
     * 최대공약수 구하기
     * 
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {

        while (b != 0) {
            
            int r = a % b;

            a = b;
            b = r;
        }
        
        return a;
    }
    
    /**
     * 최소공배수 구하기
     * 
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        
        return (a * b) / gcd(a, b);
    }
}
