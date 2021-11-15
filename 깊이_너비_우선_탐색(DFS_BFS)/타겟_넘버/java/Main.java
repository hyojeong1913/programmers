public class Main {
    
    static int answer = 0;

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};

        int target = 3;

        System.out.println(solution(numbers, target));
    }
    
    public static int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int index, int sum) {
        
        // 모든 정수를 탐색한 경우
        if (index == numbers.length) {
            
            // target 과 모든 정수를 합한 값과 같은 경우 경우의 수 증가
            if (sum == target) {
                answer++;
            }
            
            return;
        }
        
        // 해당 정수를 더해준다.
        sum += numbers[index];
        
        // 다음 수행
        dfs(numbers, target, index + 1, sum);
        
        // 위에서 더했던 정수를 다시 빼준 뒤
        sum -= numbers[index];
        
        // 해당 정수를 반대로 빼준다.
        sum += (-1) * numbers[index];
        
        // 다시 다음 수행
        dfs(numbers, target, index + 1, sum);
    }
}