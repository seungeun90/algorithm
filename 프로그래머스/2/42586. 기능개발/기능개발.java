import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
         Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int working = 0;
            if(progresses[i] < 100) {
                int left = 100 - progresses[i];

                if(left % speeds[i] != 0) {
                    working = left / speeds[i] + 1;
                } else {
                    working = left / speeds[i];
                }
            }
            days.offer(working);
        }

         List<Integer> list = new ArrayList<>();
      int count = 1;
        int cur = 0;
        while(!days.isEmpty()) {
            if (cur >= days.peek()) {
                days.poll();
                count++;
            } else {
                cur = days.poll();
            }
            
            if(days.isEmpty()) {
                list.add(count);
            } else if(cur < days.peek()){
                list.add(count);
                count=1;
                cur=0;
            }
        }


        return list.stream().mapToInt(i->i).toArray();
    }
}