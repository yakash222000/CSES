package Introductory_Problems;

import java.util.Scanner;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }

        long best = Long.MAX_VALUE;

        for (int i = 0; i < (1 << N); i++) {
            long a = 0, b = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    a += p[j];
                } else {
                    b += p[j];
                }
            }
            best = Math.min(best, Math.abs(a - b));
        }

        System.out.println(best);
    }
}
