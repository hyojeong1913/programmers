import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++) {
            queue.offer(scoville[i]);
        }
        
        while (queue.peek() < K) {
            
            if (queue.size() < 2) {
                answer = -1;
                break;
            }
            
            int q1 = queue.poll();
            int q2 = queue.poll();
            
            queue.offer(q1 + (q2 * 2));
            
            answer++;
        }
        
        return answer;
    }
}
