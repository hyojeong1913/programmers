import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] numbers = {
            {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
            {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };

        String[] hand = {"right", "left", "right"};

        for (int i=0; i<hand.length; i++) {

            System.out.println(solution(numbers[i], hand[i]));
        }
    }
    
    public static String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> left = new ArrayList<>(Arrays.asList(1, 4, 7));
        ArrayList<Integer> right = new ArrayList<>(Arrays.asList(3, 6, 9));
        
        int leftIndex = 10; // * 위치를 숫자로 표현
        int rightIndex = 12; // # 위치를 숫자로 표현
        
        for (int i=0; i<numbers.length; i++) {
            
            int tmp = numbers[i];
            
            // 0 위치를 11로 표현
            if (tmp == 0) {
                tmp = 11;
            }
            
            // 좌측 키패드인 경우
            if (left.contains(tmp)) {
                
                leftIndex = tmp;
                sb.append("L");
            }
            // 우측 키패드인 경우
            else if (right.contains(tmp)) {
                
                rightIndex = tmp;
                sb.append("R");
            }
            // 중앙 키패드인 경우
            else {
                
                // 현재 왼손의 좌표
                int[] leftCoordinate = {(leftIndex - 1) / 3, (leftIndex - 1) % 3};

                // 현재 오른손의 좌표
                int[] rightCoordinate = {(rightIndex - 1) / 3, (rightIndex - 1) % 3};

                // 현재 중앙 키패드의 좌표
                int[] currCoordinate = {tmp / 3, 1};
                
                // 왼손과의 거리
                int leftDistance = Math.abs(leftCoordinate[0] - currCoordinate[0]) + Math.abs(leftCoordinate[1] - currCoordinate[1]);
                
                // 오른손과의 거리
                int rightDistance = Math.abs(rightCoordinate[0] - currCoordinate[0]) + Math.abs(rightCoordinate[1] - currCoordinate[1]);
                
                // 오른손이 더 가까운 경우
                if (leftDistance > rightDistance) {
                        
                    rightIndex = tmp;
                    sb.append("R");
                }
                // 왼손이 더 가까운 경우
                else if (leftDistance < rightDistance) {

                    leftIndex = tmp;
                    sb.append("L");
                }
                // 거리가 같은 경우
                else {
                    // 왼손잡이인 경우
                    if (hand.equals("left")) {

                        leftIndex = tmp;
                        sb.append("L");
                    }
                    // 오른손잡이인 경우
                    else {

                        rightIndex = tmp;
                        sb.append("R");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
