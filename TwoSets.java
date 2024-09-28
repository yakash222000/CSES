import java.io.*;

public class TwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n % 4 == 1 || n % 4 == 2) {
            bw.write("NO\n");
        } else if(n % 4 == 3) {
            bw.write("YES\n");
            bw.write((n / 2) + "\n");
            for(int i = 2; i <= n / 2; i += 2) {
                bw.write(i + " " + (n - i) + " ");
            }
            bw.write(n + "\n");
            bw.write((n / 2 + 1) + "\n");
            for(int i = 1; i <= n / 2; i += 2) {
                bw.write(i + " " + (n - i) + " ");
            }
        } else {
            bw.write("YES\n");
            bw.write((n / 2) + "\n");
            for(int i = 2; i <= n / 2; i += 2) {
                bw.write(i + " " + (n - i + 1) + " ");
            }
            bw.write("\n");
            bw.write((n / 2) + "\n");
            for(int i = 1; i <= n / 2; i += 2) {
                bw.write(i + " " + (n - i + 1) + " ");
            }
        }

        bw.flush(); // Ensure all output is written
        br.close();
        bw.close();
    }
}
