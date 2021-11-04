import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[] N = {5, 4};

        int[][] stages = {
            {2, 1, 2, 6, 2, 4, 3, 3},
            {4, 4, 4, 4, 4}
        };

        for (int i=0; i<N.length; i++) {
            System.out.println(Arrays.toString(solution(N[i], stages[i])));
        }
    }

    public static Integer[] solution(int N, int[] stages) {
        
        HashMap<Integer, Integer> stageMap = new HashMap<>();
        HashMap<Integer, Double> failureMap = new HashMap<>();
        
        // 총 유저 수
        int users = stages.length;
        
        // 스테이지별 도달한 유저 수
        for (int i=0; i<users; i++) {
            
            stageMap.put(stages[i], stageMap.getOrDefault(stages[i], 0) + 1);
        }
        
        // 현재 스테이지 단계
        int currStage = 1;
        
        while (currStage <= N + 1) {
            
            for (Integer key : stageMap.keySet()) {
                
                if (key == currStage) {
                    
                    // 현재 스테이지의 실패율
                    failureMap.put(currStage, stageMap.get(key) / Double.valueOf(users));

                    // 현재 스테이지 도전 중인 사람은 다음 도전자 수에서 제외
                    users -= stageMap.get(key);
                    
                    break;
                }
            }
            
            currStage++;
        }
        
        // 실패율 없는 스테이지 실패율 0.0 처리
        for (int i=1; i<=N; i++) {
            failureMap.put(i, failureMap.getOrDefault(i, 0.0));
        }
        
        // 마지막 스테이지까지 클리어한 경우 실패율에서 제외
        failureMap.remove(N + 1);
        
        // 정렬을 위해 실패율 리스트로 변환
        List<Integer> answer = new ArrayList<Integer>(failureMap.keySet());
        
        // 실패율 내림차순으로 정렬
        Collections.sort(answer, (o1, o2) -> (failureMap.get(o2).compareTo(failureMap.get(o1))));
        
        // 마지막 array 로 변환
        return answer.toArray(new Integer[answer.size()]);
    }
}
