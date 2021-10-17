public class Main {

    public static void main(String[] args) {

        int[] n = {121, 3};

        for (int i=0; i<n.length; i++) {
            System.out.println(solution(n[i]));
        }
    }

    public static long solution(long n) {
        
        Double sqrt = Math.sqrt(n);
        
        if (sqrt == sqrt.intValue()) {
            return (long) Math.pow((sqrt + 1), 2);
        } else {
            return -1;
        }
    }
}