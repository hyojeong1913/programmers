import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
    
        long n = 118372;

        System.out.println(solution(n));
    }

    public static long solution(long n) {
        
        // 정렬하기 쉽도록 문자열로 변환
        String[] arr = String.valueOf(n).split("");
        String tmp = "";
        
        // 오름차순으로 정렬
        Arrays.sort(arr);
        
        // 역순으로 숫자 배치
        for (int i=arr.length-1; i>=0; i--) {
            tmp += arr[i];
        }
        
        // long 타입으로 변환
        return Long.parseLong(tmp);
    }
}
