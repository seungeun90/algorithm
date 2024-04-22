
import java.util.Arrays;
import java.util.Optional;
class Solution {
    int min= Integer.MAX_VALUE;
    int[] visited ;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new int[words.length];
        Optional<String> any = Arrays.stream(words).filter(w -> w.equals(target)).findAny();
        if(any.isEmpty()) return 0;

         dfs(begin, target, words,0);
         return min;
    }

    public void dfs(String begin, String target, String[] words, int cnt){

        if(begin.equals(target)) {
            min = Math.min(cnt, min);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            //한글자만 다를 경우
            if(isOneCharDiff(begin, word) && visited[i]==0) {
                visited[i] = 1;
                dfs(word, target, words, cnt+1);
                visited[i] = 0;
            }
        }
    }
    public boolean isOneCharDiff(String str, String target){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char c1 = target.charAt(i);
            if(c != c1) cnt ++;
        }
        return cnt == 1 ? true : false;
    }
}