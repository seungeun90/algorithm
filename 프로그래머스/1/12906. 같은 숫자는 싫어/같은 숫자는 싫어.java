import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
         int preNum = 10;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(preNum != arr[i]) {
                list.add(arr[i]);
            }
            preNum = arr[i];
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}