import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
		long lo=0,mid;
        long hi=0;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for(int i =0 ; i<n;i++) {
            arr[i] = scanner.nextInt();
            hi = Math.max(hi,arr[i]);
        }
        hi+=1;
        Arrays.sort(arr);

        while(lo + 1 <= hi) {
            mid = (lo + hi) /2;

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if(count<m){ // 랜선 개수가 모자라면 max값을 줄임
                hi = mid;
            }
            else{
                lo = mid +1;
            }

        }
        System.out.println(lo-1);
	}

}