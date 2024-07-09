import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int n, int[][] costs) {
         int answer = 0;
        int[] parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];

            if(find(parent, start) != find(parent, end)) {
                answer += cost;
                union(parent, start, end);
            }
        }

        return answer;
    }

    public  int find(int[] parent, int i) {
        if(parent[i]==i) return i;
        return find(parent, parent[i]);
    }
    public  void union(int[] parent, int i, int j){
        int ip = find(parent, i);
        int jp = find(parent, j);

        if(ip < jp) {
            parent[jp] = ip;
        } else{
            parent[ip] = jp;
        }
    }
}