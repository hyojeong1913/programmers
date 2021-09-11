public class Main {

    public static void main(String[] args) {
        
        int[] input = {3, 20, 4, 10};

        System.out.println(solution(input[0], input[1], input[2]));
    }

    public static long solution(int price, int money, int count) {
        
        long answer = 0;
        
        long fee = (long)count * ((long)count + 1) / 2 * (long)price;

        if (fee < money) {
            answer = 0;
        } else {
            answer = fee - money;
        }
        
        return answer;
    }
}
