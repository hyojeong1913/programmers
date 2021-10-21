import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {

        int[] bridge_length = {2, 100, 100};
        int[] weight = {10, 100, 100};
        int[][] truck_weights = {
            {7, 4, 5, 6},
            {10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
        };

        for (int i=0; i<bridge_length.length; i++) {
            System.out.println(solution(bridge_length[i], weight[i], truck_weights[i]));
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 시간
        int answer = 0;

        // 다리 위 트럭 무게의 총합
        int sum = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<truck_weights.length; i++) {
            
            // 트럭 별 해당 무게
            int w = truck_weights[i];
            
            while (true) {
                
                // 큐에 다리 길이만큼 트럭이 다 찬 경우
                if (queue.size() == bridge_length) {
                    
                    // 다리 위 트럭 무게에서 해당 트럭 무게를 빼 준다.
                    sum -= queue.poll();
                }
                // 현재 다리 위 트럭 무게 총합과 해당 트럭의 무게 합 > 다리가 견딜 수 있는 무게
                else if (sum + w > weight) {
                    
                    // 이미 다리 위에 있는 트럭이 지나갈 수 있도록 큐에 임의로 0을 넣는다.
                    queue.offer(0);

                    // 시간 증가
                    answer++;
                }
                else {
                    
                    // 해당 트럭 무게만큼 큐에 넣어준다.
                    queue.offer(w);

                    // 다리 위 트럭 총합 무게에 해당 트럭 무게 더해준다.
                    sum += w;

                    // 시간 증가
                    answer++;
                    
                    break;
                }
            }
        }
        
        // 마지막 트럭이 지나가야 하므로 다리 길이만큼 시간에 더해준다.
        return answer + bridge_length;
    }
}
