import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
          int seconds = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum=0;
        for (int i = 0; i < truck_weights.length; i++) {

            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck_weights[i]);
                    sum += truck_weights[i];
                    seconds++;
                    break;
                } else if ( queue.size() == bridge_length ) {
                    sum -= queue.poll(); //4,5
                } else {
                    int temp = truck_weights[i] + sum;
                    if(temp <= weight) {
                        seconds++;
                        sum += truck_weights[i];
                        queue.add(truck_weights[i]);
                        break;
                    } else {
                        // sum -= queue.poll(); //7.4
                        queue.add(0);
                        seconds++;
                    }
                }

            }

        }
        return seconds + bridge_length;
    }
}