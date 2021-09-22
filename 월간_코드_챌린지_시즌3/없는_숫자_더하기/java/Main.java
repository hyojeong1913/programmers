import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        
        int[][] numbers = {
            {1, 2, 3, 4, 6, 7, 8, 0},
            {5, 8, 4, 0, 6, 7, 9}
        };

        for (int i=0; i<numbers.length; i++) {
            System.out.println(solution(numbers[i]));
        }
    }

    public static int solution(int[] numbers) {
        
        int answer = 0;
        
        boolean[] flags = new boolean[10];
        
        Arrays.sort(numbers);
        
        for (int i=0; i<10; i++) {
            
            final int num = i;
            
            if (IntStream.of(numbers).anyMatch(x -> x == num)) {
                flags[i] = true;
            }
        }
        
        for (int i=0; i<flags.length; i++) {
            
            if (!flags[i]) {
                answer += i;
            }
        }
        
        return answer;
    }   
}