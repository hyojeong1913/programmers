public class Main {

    public static void main(String[] args) {

        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        
        String answer = "";
        
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int[] last_date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int days = 0;
        
        for (int i=0; i<a-1; i++) {
            
            days += last_date[i];
        }
        
        days += (b - 1);
        
        answer = day[days % 7];
        
        return answer;
    }
}
