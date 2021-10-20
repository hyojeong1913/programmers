import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[][] A = {
            {1, 4, 2},
            {1, 2}
        };

        int[][] B = {
            {5, 4, 4},
            {3, 4}
        };

        for (int i=0; i<A.length; i++) {
            System.out.println(solution(A[i], B[i]));
        }
    }

    public static int solution(int []A, int []B) {
        
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        B = reverse(B);
        
        for (int i=0; i<A.length; i++) {
            
            answer += A[i] * B[i];
        }

        return answer;
    }
    
    /**
     * 배열 역순으로 리턴
     * 
     * @param arr
     * @return
     */
    public static int[] reverse(int[] arr) {
        
        int[] result = new int[arr.length];
        
        for (int i=0; i<arr.length; i++) {
            result[i] = arr[arr.length - i - 1];
        }
        
        return result;
    }
}
