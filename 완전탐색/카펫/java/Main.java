import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[][] arr = {
            {10, 2},
            {8, 1},
            {24, 24}
        };

        for (int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(solution(arr[i][0], arr[i][1])));
        }
    }

    public static int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        // 가로 x, 세로 y 길이의 합
        int sum = 2 + (brown / 2);

        // 가로 x, 세로 y 길이의 차
        int sub = (int) Math.sqrt(Math.pow(sum, 2) - (4 * (brown + yellow)));
        
        // 가로의 길이
        int x = (sum + sub) / 2;

        // 세로의 길이
        int y = sum - x;
        
        answer[0] = x;
        answer[1] = y;
         
        return answer;
    }
}
