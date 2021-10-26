import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {
        
        int[][] progresses = {
            {93, 30, 55},
            {95, 90, 99, 99, 80, 99}
        };

        int[][] speeds = {
            {1, 30, 5},
            {1, 1, 1, 1, 1, 1}
        };

        for (int i=0; i<progresses.length; i++) {
            System.out.println(Arrays.toString(solution(progresses[i], speeds[i])));
        }
    }

    public static Integer[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 기능 개발 소요 시간 순서대로 계산해서 queue 에 입력
        for (int i=0; i<progresses.length; i++) {
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }
        
        while (!queue.isEmpty()) {
            
            // 제일 먼저 배포되어야 하는 작업의 기간
            int period = queue.poll();
            int cnt = 1;
            
            // 위 날짜에 이미 개발이 완료된 기능들을 큐에서 제거하고 개수 누적
            while (!queue.isEmpty() && period >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            
            answer.add(cnt);
        }
        
        return answer.toArray(new Integer[answer.size()]);
    }
}
