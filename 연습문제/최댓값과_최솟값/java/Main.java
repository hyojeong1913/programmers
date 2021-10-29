public class Main {

    public static void main(String[] args) {

        String[] s = {
            "1 2 3 4",
            "-1 -2 -3 -4",
            "-1 -1"
        };

        for (int i=0; i<s.length; i++) {

            System.out.println(solution(s[i]));
        }
    }

    public static String solution(String s) {
        
        String[] s_arr = s.split(" ");
        int[] arr = new int[s_arr.length];
        
        for (int i=0; i<s_arr.length; i++) {
            
            arr[i] = Integer.parseInt(s_arr[i]);
        }
        
        int max = arr[0];
        int min = arr[0];
        
        for (int i=0; i<arr.length; i++) {
            
            if (max < arr[i]) {
                max = arr[i];
            }
            else if (min > arr[i]) {
                min = arr[i];
            }
        }
        
        return min + " " + max;
    }
}
