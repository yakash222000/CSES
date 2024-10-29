import java.util.Scanner;

public class DigitQueries {
    static long pow10(int x) {
        long res = 1;
        for (int i = 0; i < x; i++) {
            res *= 10;
        }
        return res;
    }

    static int solve(long N) {
        if (N < 9) return (int) N + 1;

        int len = 1;
        while (9 * pow10(len - 1) * len < N) {
            N -= 9 * pow10(len - 1) * len;
            len++;
        }

        String S = Long.toString(pow10(len - 1) + N / len);
        return S.charAt((int) (N % len)) - '0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            long K = scanner.nextLong();
            System.out.println(solve(K - 1));
        }

        scanner.close();
    }
}
