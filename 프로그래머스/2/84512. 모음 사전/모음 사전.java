
import java.util.ArrayList;
import java.util.List;
class Solution {
    String [] words = {"A","E","I","O","U"};
    int cnt=0;
    public int solution(String word) {        
        return dfs("",word);
    }

    public int dfs(String str, String target){
        if(str.length()>5) return 0;
        if(!str.isEmpty()) {
            cnt++;
            if(str.equals(target)) {
                
                return cnt;
            }
        }
        for (String c : words) {
             int result = dfs(str + c, target);
            if (result > 0) return result;  // 목표 단어 찾으면 즉시 반환
        }
        return 0;
    }
}