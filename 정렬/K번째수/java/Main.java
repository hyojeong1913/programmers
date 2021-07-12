import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};

        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };
        
		int[] answer = solution(array, commands);
		
		System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i=0; i<commands.length; i++) {

            // Arrays.copyOfRange(array, i, j) 메소드
            // : array 의 i 번째부터 (j - 1) 번째까지 총 j - i 개의 원소를 가지는 배열 반환
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            
            // 배열 정렬
            Arrays.sort(tmp);
            
            answer[i] = tmp[commands[i][2] - 1];
        }
        
        return answer;
    }
}