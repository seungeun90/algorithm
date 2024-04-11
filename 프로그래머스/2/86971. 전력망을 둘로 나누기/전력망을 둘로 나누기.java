import java.util.ArrayList;
class Solution {
    boolean[] visited ;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        ArrayList<ArrayList<Integer>> gragh = new ArrayList<>();
        for (int i = 0; i < n +1; i++) {
            gragh.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            gragh.get(wire[0]).add(wire[1]);
             gragh.get(wire[1]).add(wire[0]);
        }
        for (int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            visited = new boolean[n+1];
            gragh.get(wire[0]).removeIf(m-> m==wire[1]);
            gragh.get(wire[1]).removeIf(m-> m==wire[0]);
            int cnt = dfs(1, gragh);
            int diff = Math.abs(cnt - (n - cnt));

            answer = Math.min(answer, diff);

            gragh.get(wire[0]).add(wire[1]);
            gragh.get(wire[1]).add(wire[0]);
        }

        return answer;
    }

    public int dfs(int node, ArrayList<ArrayList<Integer>> gragh){
        ArrayList<Integer> integers = gragh.get(node);
        visited[node] = true;
        int cnt = 1;
        for (int i = 0; i < integers.size(); i++) {

            Integer integer = integers.get(i);
            if(!visited[integer]) {
               // visited[integer] = true;
                cnt += dfs(integer, gragh);
                //visited[integer] = false;
            }
        }
        return cnt;

    }
}