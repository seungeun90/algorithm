import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] LIS = new int[n];
        LIS[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            if(LIS[len-1] < key) {
                len ++;
                LIS[len-1] = key;
            } else {
                //이분탐색으로 대체할 수 있는 가장 가까운 수를 찾기
                int lo = 0 ;
                int hi = len;
                while(lo<hi) {
                    int mid = (hi+lo)/2;

                    if(LIS[mid] < key) {
                         lo = mid+1;
                    } else {
                        hi = mid;
                    }
                }

                LIS[lo] = key;

            }
        }
        System.out.println(len);

    }
}
