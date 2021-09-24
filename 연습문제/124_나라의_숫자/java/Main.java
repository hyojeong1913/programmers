public class Main {

    public static void main(String[] args) {
    
        int[] num = {1, 2, 3, 4};

        for (int i=0; i<num.length; i++) {
            System.out.println(solution(num[i]));
        }
    }

    public static String solution(int n) {
        
        StringBuilder sb = new StringBuilder();

        int tmp = 0;
        
        while (n > 0) {
            
            // 3진수처럼 변환
            tmp = n % 3;
            n /= 3;
            
            // 0이 없으므로 3의 배수인 경우 n 에서 1을 뺀 후, 4로 대체
            if (tmp == 0) {
                n--;
                tmp = 4;
            }
            
            // 효율성 테스트를 위해서 StringBuilder 사용
            sb.insert(0, tmp);
        }
        
        return sb.toString();
    }
}
