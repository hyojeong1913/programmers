import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
    
        int[][] arr = {
            {4, 3, 2, 1},
            {10}
        };

        for (int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(solution(arr[i])));
        }
    }

    public static int[] solution(int[] arr) {
        
        // 원소가 1개인 경우 최솟값을 삭제 시 빈 배열이므로 바로 -1 배열 리턴
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int[] answer = new int[arr.length - 1];
        
        // 최솟값 임시 설정
        int min = arr[0];
        
        // 최솟값 구하기
        for (int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        // 리턴할 배열의 인덱스
        int index = 0;
        
        for (int i=0; i<arr.length; i++) {
            // 최솟값인 경우 리턴할 배열에 담지 않고 continue
            if (arr[i] == min) {
                continue;
            }
            
            // 리턴할 배열에 담고 인덱스 증가
            answer[index] = arr[i];
            index++;
        }
        
        return answer;
    }
}
