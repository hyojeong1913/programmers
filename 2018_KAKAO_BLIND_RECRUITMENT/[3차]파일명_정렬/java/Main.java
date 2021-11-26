import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        String[][] input = {
            {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
            {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}
        };

        for (int i=0; i<input.length; i++) {

            System.out.println(Arrays.toString(solution(input[i])));
        }
    }

    public static String[] solution(String[] files) {
        
        // 조건에 따른 새로운 정렬 구현
        Arrays.sort(files, new Comparator<String>() {
            
            @Override
            public int compare(String str1, String str2) {
                
                // 숫자 앞 부분들
                String head1 = str1.split("[0-9]")[0].toLowerCase();
                String head2 = str2.split("[0-9]")[0].toLowerCase();
                
                // 양수인 경우 두 자리 교체
                int res = head1.compareTo(head2);

                // 숫자 앞 부분이 같은 경우
                if (res == 0) {
                    
                    // 숫자로 비교
                    res = convert(str1, head1) - convert(str2, head2);
                }
                
                return res;
            }
        });
        
        return files;
    }
    
    /**
     * 숫자 비교하기 위한 함수
     * 
     * @param str
     * @param head
     * @return
     */
    public static int convert(String str, String head) {
        
        StringBuilder sb = new StringBuilder();
        
        // 숫자 앞 문자열들 초기화
        str = str.substring(head.length());
        
        for (char ch : str.toCharArray()) {
            
            if (Character.isDigit(ch) && sb.length() < 5) {
                sb.append(ch);
            }
            else {
                break;
            }
        }
        
        return Integer.valueOf(sb.toString());
    }
}
