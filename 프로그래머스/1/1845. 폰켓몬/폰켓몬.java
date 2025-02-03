import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
     public int solution(int[] nums) {
        int left = 0 ;
        int len = nums.length;
        int target = len / 2;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        while(left<len-1){
            int start = nums[left];
            set.add(start);

            for (int i = left+1; i < len; i++) {

                if(set.size()>=target) {
                    break;
                }
                set.add(nums[i]);
            }
            max = Math.max(max, set.size());
            set = new HashSet<>();
             left++;
        }
        return max;
    }
    
}