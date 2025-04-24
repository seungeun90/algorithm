import java.util.HashSet;
import java.util.Set;
class Solution {
    int min = Integer.MAX_VALUE;
    Set<String> visited = new HashSet<>();
    public int solution(int[][] info, int n, int m) {
        dfs(info, n, m , 0,0,0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(int[][] info, int n, int m, int idx, int sumA, int sumB) {
        if(idx == info.length) {
            if(sumB < m && sumA < n) {
                min = Math.min(min, sumA);
            } 
            return;
        }
            String key = idx + "," + sumA + "," + sumB;
        if (visited.contains(key)) return;
        visited.add(key);
        dfs(info, n, m, idx + 1, sumA + info[idx][0], sumB);
        dfs(info, n, m, idx + 1, sumA, sumB + info[idx][1]);
    }

}