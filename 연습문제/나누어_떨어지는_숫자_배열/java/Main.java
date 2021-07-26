import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    
        int[][] arr = {
            {5, 9, 7, 10},
            {2, 36, 1, 3},
            {3, 2, 6}
        };

        int[] divisor = {5, 1, 10};

        for (int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(solution(arr[i], divisor[i])));
        }
    }

    public static int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 나누어 떨어지는 경우 리스트에 추가
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);   
            }
        }
        
        // 리스트가 비었을 경우 -1 담기
        if (list.isEmpty()) {
            list.add(-1);
        }

        int[] answer = new int[list.size()];

        // 배열에 담기
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        // 오름차순으로 정렬
        Arrays.sort(answer);

        return answer;
    }
}
