public class Main {
    
    public static void main(String[] args) {
    
        int[] left = {13, 24};
        int[] right = {17, 27};

        System.out.println(solution(left[0], right[0]));
        System.out.println(solution(left[1], right[1]));
    }

    public static int solution(int left, int right) {

        int answer = 0;
        
        for (int i=left; i<=right; i++) {
            // 약수의 개수
            int cnt = 0;
            
            // 약수 개수 구하기
            for (int j=1; j<=i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            
            // 약수의 개수가 짝수인 경우 해당 수 더하기
            if (cnt % 2 == 0) {
                answer += i;
            } else { // 홀수인 경우 해당 수 빼기
                answer -= i;
            }
        }

        return answer;
    }
}
