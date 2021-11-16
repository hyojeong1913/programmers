import java.util.HashSet;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {

        int[] n = {5, 5, 3};

        int[][] lost = {
            {2, 4},
            {2, 4},
            {3}
        };

        int[][] reserve = {
            {1, 3, 5},
            {3},
            {1}
        };

        for (int i=0; i<n.length; i++) {

            System.out.println(solution(n[i], lost[i], reserve[i]));
        }
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        
        // 체육 수업 들을 수 있는 학생 수를 전체 n 명으로 초기화
        int answer = n;
        
        HashSet<Integer> reserveStudents = new HashSet<>();
        HashSet<Integer> lostStudents = new HashSet<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌의 체육복 가지고 있는 학생 리스트
        for (int i=0; i<reserve.length; i++) {
            
            reserveStudents.add(reserve[i]);
        }
        
        // 체육복 도난 당한 학생 리스트
        for (int i=0; i<lost.length; i++) {
            
            // 여벌의 체육복을 가지고 있던 학생인 경우
            if (reserveStudents.contains(lost[i])) {
                
                // 여벌의 체육복 가지고 있는 학생 리스트에서 제외
                reserveStudents.remove(lost[i]);
            }
            // 여벌의 체육복을 가지고 있지 않던 학생인 경우
            else {
                
                // 체육복 도난 당한 학생 리스트에 추가
                lostStudents.add(lost[i]);
            }
        }
        
        for (int i=0; i<lost.length; i++) {
            
            int studentIndex = lost[i];
            
            // 체육복 도난 당해 없는 학생인 경우
            if (lostStudents.contains(studentIndex)) {
                
                // 바로 이전 학생이 여벌의 체육복을 가지고 있는 경우
                if (reserveStudents.contains(studentIndex - 1)) {
                    
                    // 여벌의 체육복 가지고 있는 학생 리스트에서 이전 학생 제외
                    reserveStudents.remove(studentIndex - 1);
                }
                // 바로 이후 학생이 여벌의 체육복을 가지고 있는 경우
                else if (reserveStudents.contains(studentIndex + 1)) {
                    
                    // 여벌의 체육복 가지고 있는 학생 리스트에서 이후 학생 제외
                    reserveStudents.remove(studentIndex + 1);
                }
                // 바로 이전, 이후 학생 둘다 여벌의 체육복이 없는 경우
                else {

                    // 빌리지 못했으므로 체육 수업 들을 수 있는 학생 수 1 감소
                    answer--;
                }
            }
        }
        
        return answer;
    }
}
