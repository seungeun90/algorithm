import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
            int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
           map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }

        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            int v = iterator.next().intValue(); // 해당 종류의 의류를 착용하지 않는 경우를 포함하기 위해 +1
            answer *= v+1 ;
        }
        // 최소한 하나의 의류를 착용해야 하므로, 모든 의류를 착용하지 않는 경우를 제외한다.
        return answer-1;
    }
}