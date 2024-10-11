package Problems;

import java.io.*;

public class NumberSpiral {
    static int T;
    static long X, Y;

    public static long solve(long x, long y) {
        long l = Math.max(x, y) - 1;
        if ((l & 1) == 1) {
            if (x < y) {
                return l * l + x;
            } else {
                return l * l + 2 * l - y + 2;
            }
        } else {
            if (x < y) {
                return l * l + 2 * l - x + 2;
            } else {
                return l * l + y;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());  // Read number of test cases

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            long X = Long.parseLong(input[0]);
            long Y = Long.parseLong(input[1]);
            bw.write(solve(X, Y) + "\n");
        }

        bw.flush();  // Flush the BufferedWriter to ensure all output is written
        bw.close();
        br.close();
    }
}

