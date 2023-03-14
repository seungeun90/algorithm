import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int m = scanner.nextInt(); 

        long lo=0,mid;
        long hi=0;

        int[] arr = new int[n];
        for(int i =0 ; i<n;i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        lo = 1;
        hi = arr[n-1]-arr[0]+1;
       
        while(lo +1 <= hi) {
            mid = (lo + hi) /2;

            long count = 1;
            int prev = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] - prev >= mid) {
                    prev = arr[i];
                    count ++;
                }
            }
          //  System.out.println("lo = " + lo + ", hi = "+ hi +",mid= " +mid +", count = " + count);
            if(count<m){
                hi = mid ;
            } else{
                lo = mid +1 ;
                
            }

        }
        System.out.println(hi-1);
    }
}
