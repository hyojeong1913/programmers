public class Main {
    
    public static void main(String[] args) {

        int[] n = {3, 5};

        for (int i=0; i<n.length; i++) {
            System.out.println(solution(n[i]));
        }
    }

    public static int solution(int n) {
        
        int answer = 0;
        
        int[] fib = new int[n + 1];
        
        fib[0] = 0;
        fib[1] = 1;
        
        for (int i=2; i<=n; i++) {
            fib[i] = (fib[i - 2] + fib[i - 1]) % 1234567;
        }
        
        return fib[n];
    }
}