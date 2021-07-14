public class Main {

    public static void main(String[] args) {

        int num1 = 45;
        int num2 = 125;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    public static int solution(int n) {
        
        String str = "";
        
        // 3진법으로 변환
        while (n > 0) {
            str = (n % 3) + str;
            n /= 3;
        }
        
        // 3진수 문자열 역순으로
        StringBuffer sb = new StringBuffer(str);
        str = sb.reverse().toString();
        
        // 다시 10진수로 변환하여 리턴
        return Integer.parseInt(str, 3);
    }
}
