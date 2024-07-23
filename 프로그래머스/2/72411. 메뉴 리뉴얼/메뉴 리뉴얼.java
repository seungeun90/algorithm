import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

class Solution {

    static HashMap<String,Integer> map; 
     public static void combi(String str,StringBuilder buffer, int idx, int cnt, int n){
        if(cnt==n) {
            map.put(buffer.toString(), map.getOrDefault(buffer.toString(),0)+1);
            return;
        }

        for (int i = idx; i < str.length(); i++) {
            buffer.append(str.charAt(i));
               combi(str, buffer, i+1, cnt+1, n);
            buffer.delete(cnt, cnt+1); //start-end
        }

    }
    
    public ArrayList<String> solution(String[] orders, int[] course) {
     ArrayList<String> answer = new ArrayList<>();

        //정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }
        //조합
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(orders[j].length() >= course[i]) {
                    combi(orders[j],sb,0,0,course[i]);
                }
            }
            // 20. 가장 많이 주문된 횟수를 max에 저장.
            for(Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());

            }
            // 21. 최소 2번 이상 주문된 조합이며, 해당 횟수와 일치하는 조합은 ArrayList에 삽입.
            for(Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        // 22. 추가된 조합들을 오름차순 정렬.
        Collections.sort(answer);


        return answer;
    }
}