import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) {

        int[][] priorities = {
            {2, 1, 3, 2},
            {1, 1, 9, 1, 1, 1}
        };

        int[] location = {2, 0};

        for (int i=0; i<location.length; i++) {
            System.out.println(solution(priorities[i], location[i]));
        }
    }

    public static int solution(int[] priorities, int location) {
        
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 우선순위 높은 순으로 큐에 삽입
        for (int i=0; i<priorities.length; i++) {
            queue.offer(priorities[i]);
        }
        
        while (!queue.isEmpty()) {
            
            for (int i=0; i<priorities.length; i++) {
                
                if (queue.peek() == priorities[i]) {
                    
                    queue.poll();
                    answer++;
                    
                    // 찾던 해당 문서인 경우 큐를 비워주고 탐색 중단
                    if (i == location) {
                        queue.clear();
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
