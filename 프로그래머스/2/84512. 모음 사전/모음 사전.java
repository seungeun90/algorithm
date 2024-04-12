
import java.util.ArrayList;
import java.util.List;
class Solution {
     char[] array = { 'A', 'E', 'I', 'O', 'U'};
    List<String> list = new ArrayList<>();
     public int solution(String word) {
        dfs("");

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                return i;
            }
        }
        return 0;
    }
    
    public void dfs(String str){
        list.add(str);
        if(str.length() >= 5) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            dfs(str + array[i]);
        }
    }
}