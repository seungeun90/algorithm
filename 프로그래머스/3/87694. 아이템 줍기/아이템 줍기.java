import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0,0};
    int[] dy = {0,0,-1,1};
    List<Rect> rectList;
    //int x,y;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
        rectList = new ArrayList<>();
        for(int i=0; i<rectangle.length; i++) {
            int sx = rectangle[i][0]*2;
            int sy = rectangle[i][1]*2;
            int ex = rectangle[i][2]*2;
            int ey = rectangle[i][3]*2;

            for(int x=sx; x<=ex; x++) {
                for(int y=sy; y<=ey; y++) {
                    map[x][y] = -1;
                }
            }

            rectList.add(new Rect(sx,sy,ex,ey));
        }

        answer= bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }

    private int bfs(int[][] map, int cx, int cy, int ix, int iy) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cx,cy,1});
      //  map[cy][cx] = 1;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            int move = p[2];

            if(px == ix && py == iy){
                return move/2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(map[nx][ny] < 0 && isBoundary(nx,ny)){
                    map[nx][ny] = move+1;
                    q.add(new int[]{nx,ny,move+1});
                }
            }
        }

        return -1;
    }


    //x1,x2 보다 작거나, x3,x4 보다 크면 사각형을 벗어나서 안됨
    private boolean isBoundary(int x, int y) {
        for (Rect r  : rectList) {
            if(r.sx < x && r.sy < y
            && r.ex > x && r.ey > y) return false;
        }
        return true;
    }

    class Rect {
        int sx;
        int sy;
        int ex;
        int ey;
        public Rect(int sx, int sy, int ex, int ey){
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }


    }
}