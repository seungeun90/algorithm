
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int n, String[] words) {
           int[] answer = new int[2];
        Queue<String> queue = new LinkedList<>();
        queue.offer(words[0]);
        int cur = 0;
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            //글자 수가 1이하일때 탈락
              if(words[cur].length()<=1){ 
                answer[0]=cur%n+1;
                answer[1]=cur/n+1;
                break;
            }
             //2. 이전에 나온 단어인 경우
            for (int j = cur-1; j >= 0; j--) {
                if(poll.equals(words[j])) {
                    answer[0] = cur%n +1;
                    answer[1] = cur/n +1;
                    return answer;
                }
            }
            //1. 시작글자가 틀릴 경우
            if(cur < words.length-1 && !words[cur+1].startsWith(poll.substring(poll.length()-1))) {
                answer[0] = (cur+1)%n +1;
                answer[1] = (cur+1)/n +1;
                break;
            }

          if(cur<words.length-1) {
                queue.offer(words[++cur]);
            } else {
                break;
            }

        }
        
        return answer;
    }
}