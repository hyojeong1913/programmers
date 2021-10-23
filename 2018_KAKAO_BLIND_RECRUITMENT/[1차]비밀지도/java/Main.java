import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[] n = {5, 6};

        int[][] arr1 = {
            {9, 20, 28, 18, 11},
            {46, 33, 33 ,22, 31, 50}
        };

        int[][] arr2 = {
            {30, 1, 21, 17, 28},
            {27 ,56, 19, 14, 14, 10}
        };

        for (int i=0; i<n.length; i++) {
            System.out.println(Arrays.toString(solution(n[i], arr1[i], arr2[i])));
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            
            // 2진수 변환 및 비트 논리 연산
            String tmp = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 자릿수 맞추고, 1은 #으로 0은 빈 칸으로
            tmp = String.format("%1$" + n + "s", tmp).replace("1", "#").replace("0", " ");
            
            answer[i] = tmp;
        }
        
        return answer;
    }
}
