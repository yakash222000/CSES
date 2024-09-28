import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long max = arr[0];
        long count = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < max) {
                count += max - arr[i];
            }
            max = Math.max(max, arr[i]);
        }

        System.out.println(count);
    }
}
