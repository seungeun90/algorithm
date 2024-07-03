import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int[] nums) {
       int max = nums.length/2;
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<Integer> set = new HashSet<>(Arrays.asList(integers));
        
        return set.size() > max ? max : set.size();
    }
}