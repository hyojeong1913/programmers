import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 4, 1};
        int[] arr2 = {5, 0, 2, 7};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static ArrayList<Integer> solution(int[] numbers) {

        ArrayList<Integer> answer = new ArrayList<>();

        // 중복을 막기 위해
        boolean[] check = new boolean[201];
        
        for (int i=0; i<numbers.length-1; i++) {

            for (int j=i+1; j<numbers.length; j++) {

                int sum = numbers[i] + numbers[j];
                
                // 두 수의 합이 전에 나왔던 수인지 체크
                if (!check[sum]) {
                    answer.add(sum);
                    check[sum] = true;
                }
            }
        }
        
        // 정렬
        Collections.sort(answer);
        
        return answer;
    }
}
