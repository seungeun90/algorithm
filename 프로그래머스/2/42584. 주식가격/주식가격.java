import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q  = new LinkedList<Integer>();

        for (int i = 0; i < prices.length; i++) {
            q.add(prices[i]);
        }
        int index = 0;
        while (!q.isEmpty()) {
            Integer x = q.poll();
            for (int i = (prices.length-q.size()); i < prices.length; i++) {
                if(x > prices[i]) {
                    answer[index]++;
                    break;
                }
                answer[index] += 1;
            }
            index++;
        }
        return answer;

    }
}