import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
          String answer = "";
        Map<String, Integer>  map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        Set<String> keySet = map.keySet();
        for (String key: keySet) {
            if(map.get(key)>0) {
                answer =  key;
                break;
            };

        }
        return answer;
    }
}