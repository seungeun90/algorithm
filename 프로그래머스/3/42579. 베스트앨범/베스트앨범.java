import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
         Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }
        Map<String, Map<Integer,Integer>> music = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Map<Integer, Integer> temp = music.getOrDefault(genres[i], new HashMap<>());
            temp.put(i, plays[i]);
            music.put(genres[i], temp);
        }

        List<String> keySet1= new ArrayList(map.keySet());
        Collections.sort(keySet1, (s1, s2) -> map.get(s2) - (map.get(s1)));

        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        String tempCategory = "";
        for (String category : keySet1) {
            Map<Integer, Integer> musics = music.get(category);
            List<Integer> genreKey = new ArrayList(musics.keySet());
            Collections.sort(genreKey, (s1, s2) -> musics.get(s2) - (musics.get(s1)));

            int idx = 0;
            for (Integer i: genreKey) {
                if(tempCategory.equals("")) {
                    tempCategory = category;
                }                
                if(cnt < 2) {
                    answer.add(i);
                    cnt++;
                    /** 해당 장르의 음악이 2개 이하인 경우 */
                    if(idx == genreKey.size()-1) {
                        cnt =0 ;
                        tempCategory="";
                    }
                    idx++;

                }
                if(cnt==2) {
                    cnt =0 ;
                    tempCategory="";
                    break;
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}