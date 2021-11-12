public class Main {
    
    public static void main(String[] args) {

        long[] a = {3, 3, 5};
        long[] b = {5, 3, 3};

        for (int i=0; i<a.length; i++) {
            System.out.println(solution(a[i], b[i]));
        }
    }

    public static long solution(long a, long b) {
        
        long answer = 0;
        
        long start = a <= b ? a : b;
        long end = a > b ? a : b;
        
        for (long i=start; i<=end; i++) {
            answer += i;
        }
        
        return answer;
    }
}
