import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
             Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.compute(completion[i], (k,v) -> v-1);
        }
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if(map.get(key)!=0) {
                return key;
            }
        }
        return null;
    }
}