
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); //0 1 3 5 6 //0 1 5 5 6

        int middle = citations.length / 2;
        while(true) {
            int temp = citations[middle];
            for (int i = middle+1; i < citations.length; i++) {
                //중간값 뒤에 있는 애들이 중간값보다 작을 때
                if(citations[i] < middle) {
                    temp -= 1;
                    break;
                }
            }
            for (int i = 0; i < middle; i++) {
                if (citations[i] > middle) {
                    temp += 1;
                    break;
                }
            }
            return temp;
        }
    }
}