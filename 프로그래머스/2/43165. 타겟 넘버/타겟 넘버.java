class Solution {
      int cnt;
    public int solution(int[] numbers, int target) {
     int answer = 0;
        dfs(target,numbers, 0, 0);
        answer = cnt;
        return answer;
    }
     
   public void dfs(int target, int[] numbers, int sum, int idx){
        if(idx == numbers.length ) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        dfs(target, numbers, sum + numbers[idx], idx +1);
        dfs(target, numbers, sum - numbers[idx], idx+1);

    }
}