package Introductory_Problems;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n-1];
        for(int i=1;i<n;i++){
            arr[i-1]=sc.nextInt();
        }
        int total = 1;
        for (int i = 2; i <= n; i++) {
            total += i;
            total -= arr[i - 2];
        }
        System.out.println(total);
    }
}
