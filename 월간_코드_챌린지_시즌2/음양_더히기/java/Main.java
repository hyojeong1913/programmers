public class Main {

    public static void main(String[] args) {
        
        int[][] absolutes = {
            {4, 7, 12},
            {1, 2, 3}
        };

        boolean[][] signs = {
            {true, false, true},
            {false, false, true}
        };

        System.out.println(solution(absolutes[0], signs[0]));
        System.out.println(solution(absolutes[1], signs[1]));
    }

    public static int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;
        
        for (int i=0; i<absolutes.length; i++) {
            // sign 이 true 이면 더해준다.
            if (signs[i] == true) {
                answer += absolutes[i];
            } else { // 반대로 false 이면 빼준다.
                answer -= absolutes[i];
            }
        }
        
        return answer;
    }   
}
