package Problems;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n != 1) {
            System.out.print(n+" ");
            if(n%2 == 0) {
                n /= 2;
            }
            else {
                n = n*3 + 1;
            }
        }

        System.out.print(n);
    }
}
