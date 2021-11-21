import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[][] people = {
            {70, 50, 80, 50},
            {70, 80, 50}
        };

        int[] limit = {100, 100};

        for (int i=0; i<people.length; i++) {

            System.out.println(solution(people[i], limit[i]));
        }
    }

    public static int solution(int[] people, int limit) {
        
        int answer = 0;
        int minIndex = 0;
        
        Arrays.sort(people);
        
        for (int i=people.length-1; i>=minIndex; i--) {
            
            if (people[minIndex] + people[i] <= limit) {
                
                minIndex++;
            }
            
            answer++;
        }
        
        return answer;
    }
}
