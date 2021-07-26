import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] arr1 = {
            {1, 2},
            {2, 3}
        };

        int[][] arr2 = {
            {3, 4},
            {5, 6}
        };

        // Arrays.deepToString 메소드 : 다차원 배열의 값도 문자열로 리턴받아 쉽게 출력 가능
        System.out.println(Arrays.deepToString(solution(arr1, arr2)));

        int[][] arr3 = {
            {1}, {2}
        };

        int[][] arr4 = {
            {3}, {4}
        };

        // Arrays.deepToString 메소드 : 다차원 배열의 값도 문자열로 리턴받아 쉽게 출력 가능
        System.out.println(Arrays.deepToString(solution(arr3, arr4)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        // 두 행렬 덧셈
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}
