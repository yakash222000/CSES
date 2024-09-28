import java.util.Scanner;


public class BitStrings {

    static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 1;
        long pow = 2;
        while(n>0) {
            if(((n&1) == 1)) {
                res = (res * pow) % MOD;
            }
            pow = (pow * pow) % MOD;
            n>>=1;
        }
        System.out.println(res);
    }
}
