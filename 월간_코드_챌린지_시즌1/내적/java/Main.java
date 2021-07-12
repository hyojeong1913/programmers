public class Main {
    
    public static void main(String[] args) {
        
        int[][] arr1 = {
            {1, 2, 3, 4},
            {-3, -1, 0, 2}
        };

        int[][] arr2 = {
            {-1, 0, 1},
            {1, 0, -1}
        };

        System.out.println(solution(arr1[0], arr1[1]));
        System.out.println(solution(arr2[0], arr2[1]));
    }

    /**
     * 내적
     * (a[0] * b[0]) + (a[1] * b[1]) + ... + (a[n-1] * b[n-1])
     * 
     * @param a
     * @param b
     * @return
     */
    public static int solution(int[] a, int[] b) {
        int sum = 0;
        
        // 내적 계산식
        for (int i=0; i<a.length; i++) {
            sum += (a[i] * b[i]);
        }
        
        return sum;
    }
}
