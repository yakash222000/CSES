package Mathematics;

import java.io.*;

public class CountingDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int count = 1;
            int divisor = 0;
            while (x%2 == 0) {
                divisor++;
                x /= 2;
            }
            count *= (divisor+1);
            for (int i = 3; i*i <= x; i+=2) {
                divisor = 0;
                while (x%i == 0) {
                    divisor++;
                    x /= i;
                }
                count *= (divisor+1);
            }
            if(x>2) count *= 2;
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();

    }
}
