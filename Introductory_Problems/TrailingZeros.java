package Introductory_Problems;

import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tz(n));
        sc.close();
    }
    public static int tz(int n) {
        int res=0;
        int i=5;
        while(i<=n) {
            res+=n/i;
            i*=5;
        }
        return res;

    }

}
