import java.io.*;

public class TwoKnights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());


        for(int i = 1; i <= t; i++) {
            long totalWays = (long) i * i * (i * i - 1) / 2;  // Total ways to place two knights
            long attackWays = 4 * (i - 1) * (i - 2);           // Ways knights can attack each other
            long validWays = totalWays - attackWays;
            bw.write(validWays + "\n");
        }

        bw.flush();  // Flush the BufferedWriter to ensure all output is written
        bw.close();
        br.close();

    }
}
