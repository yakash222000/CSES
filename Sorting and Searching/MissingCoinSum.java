import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MissingCoinSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long sum = 1;
        boolean found = true;
        for (int i = 0; i < n; i++) {
            if(arr[i] > sum) {
                bw.write(sum + " ");
                found = false;
                break;
            }
            sum += arr[i];
        }
        if(found) {
            bw.write(sum + " ");
        }
        bw.flush();
    }
}
