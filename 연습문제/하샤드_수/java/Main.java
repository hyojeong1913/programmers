public class Main {
    
    public static void main(String[] args) {

        int[] num = {10, 12, 11, 13};

        for (int i=0; i<num.length; i++) {
            System.out.println(solution(num[i]));
        }
    }

    public static boolean solution(int x) {
        
        boolean answer = true;
        
        // 각 자리 수의 합
        int sum = 0;

        int tmp = x;
        
        // 각 자리 수의 합 계산
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        
        // 하샤드 수인지 판별
        if (x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}
