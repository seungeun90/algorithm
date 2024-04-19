class Solution {
    boolean[] visited ;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
    
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
            
        }
        return answer;
    }
    public void dfs(int[][] computers, int node){
        visited[node] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if(computers[node][i] == 1 && node!=i && !visited[i]) {
                dfs(computers, i);
            }

        }
    }
}