class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
      int answer = 0;

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        if(start == 0 || start == 43200) answer ++;

        int t = start;

        while (t < end) {
            double H = (t / 120.0) % 360; // 1시간/360도 =1초= 360/43200(초) = 1/120
            double M = (t / 10.0) % 360;  //1분/360도 = 1초 = 360/3600(초) = 1/10
            double S = (t * 6.0) % 360; //60초/360도 = 360/60(초) = 6

            double Hn = ((t+1) / 120.0) % 360;
            double Mn = ((t+1) / 10.0) % 360;
            double Sn = ((t+1) * 6.0) % 360;
            
            if(Hn == 0) Hn = 360;
            if(Mn == 0) Mn = 360;
            if(Sn == 0) Sn = 360;
            
            if(S < H && Hn <= Sn) {
                answer++;
            }
            if(S < M && Mn <= Sn) {
                answer++;
            }
            if(Hn == Mn && Mn == Sn ) {
                answer--;
            }
            t++;
        }

        return answer;
    }
}