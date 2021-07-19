public class Main {
    
    public static void main(String[] args) {
    
        int[][] nums = {
            {1, 2, 3, 4},
            {1, 2, 7, 6, 4}
        };

        for (int i=0; i<nums.length; i++) {
            System.out.println(solution(nums[i]));
        }
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        
        for (int i=0; i<nums.length-2; i++) {

            for (int j=i+1; j<nums.length-1; j++) {

                for (int k=j+1; k<nums.length; k++) {
                    // 세 수의 합
                    sum = nums[i] + nums[j] + nums[k];
                    
                    // 소수이면 개수 1 증가
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    /**
     * 소수인지 판별
     * 
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        for (var i=2; i<num; i++) {
            // 1과 자기 자신을 뺀 나머지의 수 중에서 나눠떨어지는 수가 존재하면 false 리턴
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
