import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //행렬 사이즈
        int m = scanner.nextInt(); //m번째 수

        long lo = 1;
        long hi = m;

        long mid;

        while(lo+1<=hi){
            mid = (lo+hi) /2;

            long count=0;
            for (int i = 1; i <= n; i++) {
                count += Math.min((mid/i),n);
            }
            //System.out.println("lo = " + lo +" , hi= "+ hi + ", mid= " + mid+ " , cnt= " + count);
            if(m<=count){ //m번째 숫자보다 작거나 같은 수의 갯수가 m보다 많으면 범위를 줄여야해 ..
                hi = mid;
            } else {
                lo = mid+1;
            }

        }
        System.out.println(lo);
    }
}
