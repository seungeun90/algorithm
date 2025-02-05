
import java.util.LinkedList;
import java.util.Queue;

class Solution {
        int cnt=Integer.MAX_VALUE;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        Queue<Point> q = new LinkedList();
        q.offer(new Point(0,0,1));

        while(!q.isEmpty()) {
            Point point = q.poll();
            if(point.x== maps.length-1 && point.y==maps[0].length-1) {
                return point.distance;
            }
            for (int i = 0; i < dx.length; i++) {
                int row = point.x + dx[i];
                int col = point.y + dy[i];
                if(row >= 0 && row < maps.length&& col >= 0 && col < maps[0].length){
                    if(!visited[row][col] && maps[row][col]!=0) {
                        visited[row][col] = true;
                        q.offer(new Point(row,col, point.distance+1));
                    }
                }
            }
        }
        return -1;
    }
    class Point{
        int x;
        int y;
        int distance;
        public Point(int x, int y, int distance){
            this.x= x;
            this.y=y;
            this.distance = distance;
        }
    }
    public void dfs(int sum, int x, int y,int[][] maps){
        if(x== maps.length-1 && y==maps[0].length-1) {
            cnt = Math.min(sum, cnt);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int row = x + dx[i];
            int col = y + dy[i];
            if(row >= 0 && row < maps.length&& col >= 0 && col < maps[0].length){
                if(!visited[row][col] && maps[row][col]!=0) {
                    visited[row][col] = true;
                    dfs(sum+1, row, col, maps);
                    visited[row][col] = false;
                }
            }
        }
    }
}