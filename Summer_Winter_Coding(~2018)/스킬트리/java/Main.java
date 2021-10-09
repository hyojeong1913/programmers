public class Main {

    public static void main(String[] args) {

        String skill = "CBD";

        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));
    }
    
    public static int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for (int i=0; i<skill_trees.length; i++) {
            
            String[] arr = skill_trees[i].split("");
            
            int index = 0;
            boolean flag = true;
            
            for (int j=0; j<arr.length; j++) {
                
                if (index < skill.indexOf(arr[j])) {
                    flag = false;
                    break;
                }
                
                if (index == skill.indexOf(arr[j])) {
                    index++;
                }
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
}
