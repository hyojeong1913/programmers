public class Main {

    public static void main(String[] args) {
        
        int[][] scoresA = {
            {100, 90, 98, 88, 65},
            {50, 45, 99, 85, 77},
            {47, 88, 95, 80, 67},
            {61, 57, 100, 80, 65},
            {24, 90, 94, 75, 65}
        };

        int[][] scoresB = {
            {50, 90},
            {50, 87}
        };

        int[][] scoresC = {
            {70, 49, 90},
            {68, 50, 38},
            {73, 31, 100}
        };

        System.out.println(solution(scoresA));
        System.out.println(solution(scoresB));
        System.out.println(solution(scoresC));
    }

    static String solution(int[][] scores) {
        
        String answer = "";
        
        int[] own_score = new int[scores.length];
        
        for (int i=0; i<scores.length; i++) {
            own_score[i] = scores[i][i];
        }
        
        for (int i=0; i<scores.length; i++) {
            
            int max = -1;
            int min = 101;
            
            int sum = 0;
            int cnt = scores.length;
            
            boolean is_dup_max = false;
            boolean is_dup_min = false;
            
            for (int j=0; j<scores.length; j++) {
                
                sum += scores[j][i];
                
                if (scores[j][i] == max) {
                    is_dup_max = true;
                }
                
                if (scores[j][i] == min) {
                    is_dup_min = true;
                }
                
                if (scores[j][i] > max) {
                    max = scores[j][i];
                }
                
                if (scores[j][i] < min) {
                    min = scores[j][i];
                }
            }
            
            if (max == own_score[i] && !is_dup_max) {
                sum -= own_score[i];
                cnt -= 1;
            }
            
            if (min == own_score[i] && !is_dup_min) {
                sum -= own_score[i];
                cnt -= 1;
            }
            
            answer += getGrade(sum / cnt);
        }
        
        return answer;
    }
    
    static String getGrade(int score) {
    
        if (score >= 90) {
            return "A";
        } else if (score >= 80 && score < 90) {
            return "B";
        } else if (score >= 70 && score < 80) {
            return "C";
        } else if (score >= 50 && score < 70) {
            return "D";
        } else {
            return "F";
        }
    }
    
}