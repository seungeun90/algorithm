
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        Integer integer = set.stream().max(Comparator.comparing(x -> x)).get();
        return integer != 0 ? integer : answer;
    }

    public  void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int[] dungeon = dungeons[i];
                if(k>=dungeon[0]) {                   
                    dfs(k-dungeon[1], dungeons, visited,cnt+1);
                }
                visited[i] = false;
             
            }
        }
           set.add(cnt);
    }
}