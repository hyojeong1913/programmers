import java.util.HashSet;
import java.util.Iterator;

public class Main {

    static HashSet<Integer> numSet = new HashSet<>();
    
    public static void main(String[] args) {

        String[] numbers = {"17", "011"};

        for (int i=0; i<numbers.length; i++) {
            
            System.out.println(solution(numbers[i]));
        }
    }

    public static int solution(String numbers) {
        
        int answer = 0;
        
        comb("", numbers);
        
        Iterator<Integer> iter = numSet.iterator();
        
        while (iter.hasNext()) {
            
            if (isPrime(iter.next())) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void comb(String str1, String str2) {
        
        if (!str1.equals("")) {
            
            numSet.add(Integer.valueOf(str1));
        }
        
        for (int i=0; i<str2.length(); i++) {
            
            comb(str1 + str2.charAt(i), str2.substring(0, i) + str2.substring(i + 1, str2.length()));
        }
    }
    
    public static boolean isPrime(int num) {
        
        if (num % 2 == 0) {
            
            if (num == 2) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            
            if (num == 1) {
                return false;
            }
            
            for (int i=3; i<=(int)Math.sqrt(num); i=i+2) {
                
                if (num % i == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
