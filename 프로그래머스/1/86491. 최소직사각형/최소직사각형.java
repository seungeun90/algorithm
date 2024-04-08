class Solution {
     public int solution(int[][] sizes) {
        int w_max = 0;
        int h_max = 0;

        for (int i = 0; i < sizes.length; i++) {
            w_max = Math.max(w_max,Math.max(sizes[i][0], sizes[i][1]));
            h_max = Math.max(h_max,Math.min(sizes[i][0], sizes[i][1]));
        }

        return w_max * h_max;
    }
}