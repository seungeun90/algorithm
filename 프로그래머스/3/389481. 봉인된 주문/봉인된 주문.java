import java.util.Arrays;
class Solution {
    public String solution(long n, String[] bans) {
             long[] banIdx = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            banIdx[i] = toIndex(bans[i]); // 위에서 만든 함수
        }
        Arrays.sort(banIdx);
        for (int i = 0; i < banIdx.length; i++) {
            if(banIdx[i] <= n) {
                n ++; //bans가 빠지면 순서가 뒤로 밀리니까 
            }else {
                break;
            }
        }
        return makeStr(n);
    }
    
     public String makeStr(long n){
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--; //0으로 계산
            sb.append((char) ('a' + (n % 26))); 
            n /= 26; //남은 문자열 길이로 업데이트
        }
        return sb.reverse().toString();
    }
      public long toIndex(String str){
        long n = 0;
        for(int i = 0; i < str.length(); i++){
            int v = str.charAt(i) - 'a' + 1;
            n = n * 26 + v;
        }
        return n;
    }
}