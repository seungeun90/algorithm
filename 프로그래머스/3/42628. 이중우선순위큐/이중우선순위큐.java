import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
       PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String str = operations[i];
            if(str.startsWith("I")) {
                 q.offer(Integer.valueOf(str.split(" ")[1]));
            } else if(str.equals("D 1")) { //최대값 삭제
                q = removeLastElement(q);
            } else if(str.equals("D -1")) { //최소값 삭제
                q.poll();
            }

        }
         int[] answer = new int[2];
         if(q.size()==0) {
            answer[0] = 0;
            answer[1] = 0;
        } else if(q.size() == 1) {
            if(q.peek() < 0) {
                answer[0] = 0;
                answer[1] = q.poll();        
            } else {
                answer[0] = getLastElement(q);
                answer[1] = 0;    
            }
        } else { //[최대값, 최소값]
            answer[1] = q.peek();
            answer[0] = getLastElement(q);
        }
        return answer;
    }
    public static Integer getLastElement(PriorityQueue<Integer> priorityQueue) {
        // PriorityQueue를 List로 변환
    
        List<Integer> list = new ArrayList<>(priorityQueue);
        Collections.sort(list);
        return list.get(list.size()-1);
    }
    
     public static PriorityQueue<Integer> removeLastElement(PriorityQueue<Integer> priorityQueue) {
        // PriorityQueue를 List로 변환
        List<Integer> list = new ArrayList<>(priorityQueue);

        // 마지막 요소 삭제
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }

        // 새로운 PriorityQueue 생성
        PriorityQueue<Integer> newPriorityQueue = new PriorityQueue<>(list);

        return newPriorityQueue;
    }
}