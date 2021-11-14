import java.util.Stack;

public class Main {
    
    public static void main(String[] args) {

        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        
        int answer = 0;
        
        // 인형 담을 바구니
        Stack<Integer> basket = new Stack<>();
        
        for (int i=0; i<moves.length; i++) {
            
            int boardIndex = moves[i];
            
            for (int j=0; j<board.length; j++) {
                
                int dollIndex = board[j][boardIndex - 1];
                
                // 해당 칸에 인형이 존재하는 경우
                if (dollIndex != 0) {
                    
                    // 바구니가 비어있는 경우
                    if (basket.isEmpty()) {

                        // 바구니에 인형 삽입
                        basket.push(dollIndex);
                    }
                    // 바구니가 비어있지 않는 경우
                    else {
                        
                        // 바구니 맨 위에 있는 인형과 해당 인형이 같은 경우
                        if (basket.peek() == dollIndex) {
                            
                            // 사라진 인형 개수 2개 누적
                            answer += 2;
                            
                            // 해당 인형과 동일한 맨 위 인형 바구니에서 제거
                            basket.pop();
                        }
                        // 바구니 맨 위에 있는 인형과 해당 인형이 다른 경우
                        else {
                            
                            // 바구니에 인형 삽입
                            basket.push(dollIndex);
                        }
                    }
                    
                    // 해당 인형을 크레인으로 뺐으므로 0 으로 대체
                    board[j][boardIndex - 1] = 0;
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}
