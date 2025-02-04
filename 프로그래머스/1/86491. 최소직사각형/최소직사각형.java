class Solution {
     public int solution(int[][] sizes) {  int len = sizes.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int[] size = sizes[i];
            max = Math.max(Math.max(size[0],size[1]), max);
            min = Math.min(Math.min(size[0],size[1]), min);
        }
        for (int i = 0; i < len; i++) {
            int[] size = sizes[i];
            int smaller = Math.min(size[0],size[1]);
            if(min < smaller) {
                min = smaller;
            }
        }

        return max * min;

    }
}