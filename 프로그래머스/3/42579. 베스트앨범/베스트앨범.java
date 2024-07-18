import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
       Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }
        //map 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2)-> map.get(o2) - map.get(o1));

        List<Integer> answer = new ArrayList<>();
        for (String key : keySet) {
            Map<Integer, Integer> x = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if(key.equals(genres[i])) {
                    x.put(i, plays[i]);
                }
            }
            List<Integer> k = new ArrayList<>(x.keySet());
            k.sort((o1,o2)->x.get(o2)-x.get(o1));

            int cnt=0;
            for (Integer s : k) {
                if(cnt<2) {
                    answer.add(s);
                    cnt++;
                } else break;
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}