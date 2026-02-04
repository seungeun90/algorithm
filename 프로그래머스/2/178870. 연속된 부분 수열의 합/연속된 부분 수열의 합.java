class Solution {
  public static int[] solution(int[] sequence, int k) {
         int l = 0 ;
        int sum = 0;
        int n =  sequence.length ;
        int bestL=0; int bestR=n-1;// 최악의 경우 (구간 크게) r-l 이 클수록 최악 

        for (int r = 0; r < n; r++) {
            sum += sequence[r];
            while (sum > k) {
                sum -= sequence[l++];
            }
            if(sum==k) {
                if ((r - l) < (bestR - bestL) || ((r - l) == (bestR - bestL) && l < bestL)) {
                    bestL = l;
                    bestR = r;
                }
            }
        }
        return new int[]{bestL, bestR};
  }
}