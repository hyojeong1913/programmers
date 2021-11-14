public class Main {
    
    public static void main(String[] args) {

        String[] dartResult = {
            "1S2D*3T",
            "1D2S#10S",
            "1D2S0T",
            "1S*2T*3S",
            "1D#2S*3S",
            "1T2D3D#",
            "1D2S3T*"
        };

        for (int i=0; i<dartResult.length; i++) {

            System.out.println(solution(dartResult[i]));
        }
    }

    public static int solution(String dartResult) {
        
        int tmpScore = 0;
        int index = 0;
        int n = 0;
        
        int[] score = new int[3];
        
        for (int i=0; i<dartResult.length(); i++) {
            
            char ch = dartResult.charAt(i);
            
            // 해당 문자가 숫자형 점수인 경우
            if (Character.isDigit(ch)) {
                
                // 다트 점수가 10점인 경우
                if (ch == '1' && dartResult.charAt(i + 1) == '0') {
                    n = 10;
                    i++;
                }
                else {
                    n = Character.getNumericValue(ch);
                }
                
                tmpScore++;
            }
            // 해당 문자가 보너스 또는 옵션에 해당하는 문자인 경우
            else {
                switch (ch) {
                    // 1제곱
                    case 'S':
                        score[index++] = (int) Math.pow(n, 1);
                        break;
                    // 2제곱
                    case 'D':
                        score[index++] = (int) Math.pow(n, 2);
                        break;
                    // 3제곱
                    case 'T':
                        score[index++] = (int) Math.pow(n, 3);
                        break;
                    // 스타상
                    case '*':
                        // 이전의 점수들 각 2배씩
                        index = index < 2 ? 0 : index - 2;
                        
                        while (index < tmpScore) {
                            score[index++] *= 2;
                        }
                        
                        n = 0;
                        break;
                    // 아차상
                    case '#':
                        // 가장 최근 점수를 마이너스로
                        score[index - 1] *= -1;
                        
                        n = 0;
                        break;
                }
            }
        }
        
        // 점수 합산하여 리턴
        return score[0] + score[1] + score[2];
    }
}
