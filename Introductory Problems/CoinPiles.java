import java.io.*;

public class CoinPiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());  // Number of test cases
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if ((a + b) % 3 == 0 && a <= 2 * b && b <= 2 * a) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();  // Ensure all output is written
        bw.close();
        br.close();
    }
}
