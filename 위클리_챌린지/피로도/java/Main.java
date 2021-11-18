public class Main {
    
    static boolean[] check;
    static int answer = 0;

    public static void main(String[] args) {

        int k = 80;

        int[][] dungeons = {
            {80, 20},
            {50, 40},
            {30, 10}
        };

        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        
        check = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public static void dfs(int k, int[][] dungeons, int count) {
        
        for (int i=0; i<dungeons.length; i++) {
            
            if (!check[i] && dungeons[i][0] <= k) {
                
                check[i] = true;
                
                dfs(k - dungeons[i][1], dungeons, count + 1);
                
                check[i] = false;
            }
        }
        
        answer = Math.max(answer, count);
    }
}
