import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
         int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);

            for (int j = 0; j < temp.length-1; j++) {
                for (int k = j+1; k < temp.length; k++) {
                    if(temp[j] > temp[k]) {
                        int t = temp[j];
                        temp[j] = temp[k];
                        temp[k] = t;
                    }
                }
            }
            
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
}