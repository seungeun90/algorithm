class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
         int lo = 1;
        int hi = 1;
        for(int diff : diffs) {
            hi = Math.max(hi, diff);
        }

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(solve(diffs, times, limit, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        return lo;
    }
    
    public boolean solve(int[] diffs, int[] times, long limit, int level) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
              int timePrev = (i == 0) ? 0 : times[i - 1];
            if(diff > level){
                long failCnt = diff - level;
                sum += ((long) (times[i] + timePrev) * failCnt) + times[i];
            } else {
                sum += times[i];
            }
         if(sum > limit) {
                return false;
            }
        }
           
        return  sum <= limit;
    }
}