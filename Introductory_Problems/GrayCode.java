package Introductory_Problems;

import java.io.*;

public class GrayCode {

    final static int max = 16;
    static boolean[] b = new boolean[max + 1];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        print(bw);

        for (int i = 1; i < (1 << n); i++) {
            int LSB = (i == 0) ? 0 : Integer.numberOfTrailingZeros(i) + 1;
            b[LSB] ^= true;
            print(bw);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    // Function to print the current boolean array as a binary number using BufferedWriter
    public static void print(BufferedWriter bw) throws IOException {
        for (int i = n; i > 0; i--) {
            bw.write(b[i] ? '1' : '0');
        }
        bw.write("\n");  // Newline after printing the binary number
    }
}
