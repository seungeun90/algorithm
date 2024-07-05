
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); //0 1 3 5 6

         Arrays.sort(citations); //0 1 3 5 6

        for (int i = 0; i < citations.length-1; i++) {
            int h = citations.length - i;
            if(citations[i] >= h) {
               return h;
            }
        }
        
        return 0;
        
    }
}