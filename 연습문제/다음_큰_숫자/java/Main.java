public class Main {
    
    public static void main(String[] args) {

        int[] num = {78, 15};

        for (int i=0; i<num.length; i++) {
            System.out.println(solution(num[i]));
        }
    }

    public static int solution(int n) {
        
        int answer = n;

        // n 을 이진수로 변환하여 나온 1의 개수
        int cnt = Integer.bitCount(n);
        
        while (true) {
            
            answer++;
            
            // n 의 1의 개수와 같은 경우 반복문 빠져나온다.
            if (Integer.bitCount(answer) == cnt) {
                
                break;
            }
        }
        
        return answer;
    }
}
