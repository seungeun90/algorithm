import java.util.*;

class Solution {
     int[] row = {-1 ,0,1,0};
    int[] col = {0,1,0,-1};

    public int solution(int[][] land) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();

        boolean [][]visited = new boolean [land.length][land[0].length];
        int[] colOil = new int[land[0].length];
        for (int i = 0; i < land.length; i++) {
             for (int j = 0; j < land[i].length; j++) {
                 if (land[i][j] == 1 && !visited[i][j]) {

                     int size = 0;
                     boolean[] cols = new boolean[land[i].length];

                     visited[i][j] = true;

                     queue.offer(new int[]{i,j});
                     while (!queue.isEmpty()) {
                         int[] oil = queue.poll();
                                                      
                             size ++;
                         for (int k = 0; k < 4; k++) {

                             cols[oil[1]] = true;
                             int nextRow = oil[0] + row[k];
                             int nextCol = oil[1] + col[k];
                             if(nextRow >= 0 && nextRow < land.length && nextCol >= 0 && nextCol < land[0].length) {
                                 if(land[nextRow][nextCol] == 1 && !visited[nextRow][nextCol] ) {
                                     visited[nextRow][nextCol] = true;
                                     queue.offer(new int[]{nextRow,nextCol});
                                 }
                             }
                         }
                     }

                     for (int k = 0; k < land[0].length; k++) {
                         if(cols[k]) {
                             colOil[k] += size;
                         }
                     }

                 }
             }
         }

        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, colOil[i]);
        }
        return answer;
    }


}