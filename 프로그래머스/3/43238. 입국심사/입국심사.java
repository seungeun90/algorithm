import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
         long answer = 0;
        Arrays.sort(times);

        long left = 0; //최소시간
        long right = times[times.length-1] * (long)n;//최대시간

        while(left<=right) {
            long cnt = 0;
            long mid = (left + right) /2;
            for (int i = 0; i < times.length; i++) {
                cnt += mid/ times[i];
            }
            if(cnt<n) {
                left = mid+1;
            } else {
                right = mid-1;
                answer = mid;
            }
        }

        return answer;
    }
}