import java.util.*;
import java.util.List;
class Solution {
      public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = points.length; //로봇의 수
        /*
        * 각 로봇이 현재 위치에서 목적지까지 이동하는 좌표 기록
        * */
        int[] row = new int[n+1];
        int[] col = new int[n+1];
        for (int i = 0; i < points.length; i++) {
            row[i+1] = points[i][0];
            col[i+1] = points[i][1];
        }
        List<List<int[]>> allPaths = new ArrayList<>();
        
        int maxTime = 0;
        //모든 로봇의 이동경로
        for (int i = 0; i < routes.length; i++) {
            List<int[]> path = buildPathForRobot(routes[i], row, col);
            allPaths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        for (int t = 0; t < maxTime; t++) {
            Map<Location, Integer> map = new HashMap<>();

            for (List<int[]> path : allPaths) {
                if( t < path.size()) {
                    int[] loc = path.get(t);
                    map.put(new Location(loc[0], loc[1]), 
                            map.getOrDefault(new Location(loc[0], loc[1]), 0) + 1);
                }
            }
            for(int v : map.values()) {
                if(v > 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private List<int[]> buildPathForRobot(int[] route, int[] row, int[] col) {
        List<int[]> path = new ArrayList<>();
        //로봇의 출발지
        int curR = row[route[0]];
        int curC = col[route[0]];
        path.add(new int[]{curR, curC});

        //다음 목적지까지 루트 구하기
        for (int i = 0; i < route.length-1; i++) {
            int nextPoint = route[i + 1];
            int nextR = row[nextPoint];
            int nextC = col[nextPoint];

            while(curR!=nextR) {
                if(nextR > curR) {
                    curR += 1;
                } else {
                    curR -= 1;
                }
                path.add(new int[]{curR, curC});
            }
            while (curC != nextC) {
                if(nextC > curC) {
                    curC += 1;
                } else {
                    curC -= 1;
                }
                path.add(new int[]{curR, curC});
            }

        }
        return path;
    }

    class Location {
        int r;
        int c;
        public Location(int x, int y) {
            this.r = x;
            this.c = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return r == location.r && c == location.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}