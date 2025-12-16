import java.util.ArrayList;
import java.util.List;
class Solution {
     static int[] pick =new int[5];
    static List<int[]> codes = new ArrayList<>();
       public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int[] arr= new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }
        dfs(0,0, arr);

        for (int[] code : codes) {
            if(isValid(code, q, ans)) {
                answer++;
            };
        }

        return answer;
    }
    public void dfs(int dept, int start, int[] arr){
        if(dept == 5){
            codes.add(pick.clone());
            return;
        }
        for (int i = start; i < arr.length; i++) {
            pick[dept] = arr[i];
            dfs(dept + 1, i+1 , arr);
        }
    }

    public boolean isValid(int[] code, int[][] q, int[] ans) {
        boolean flag = false;
        for (int i = 0; i < q.length; i++) {
            int match = 0;
            int[] ints = q[i];
            for (int j = 0; j < code.length; j++) {
                for (int k = 0; k < ints.length; k++) {
                    if(code[j]==ints[k]){
                        match++;
                        break;
                    }
                }
            }
            if(match != ans[i]) {
                return false;
            }
        }
        return true;
    }
}