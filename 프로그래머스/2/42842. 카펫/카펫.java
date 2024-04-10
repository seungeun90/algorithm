class Solution {
    public int[] solution(int brown, int yellow) {
          int[] answer = new int[2];
        int S = brown + yellow;
        for (int width = S-1; width > 0; width--) {
            if(S % width != 0) continue;
            int height = S/width;
            if(height > width) continue;

            int y = (width - 2) * (height -2);
            if(y==yellow && (S-y) == brown) {
                answer[0] = width;
                answer[1] = height;
            }
        }

        return answer;
    }
}