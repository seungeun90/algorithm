import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
       Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            q.offer(prices[i]);
        }

        int idx = 0;
        while(!q.isEmpty()) {

            Integer pre = q.poll();
            int cnt = 0;
            for (int i = idx+1; i < prices.length; i++) {
                if(pre <= prices[i]) {
                    answer[idx] += 1;
                } else {
                    answer[idx] ++;
                    break;
                }
            }
            idx++;

        }
        return answer;

    }
}