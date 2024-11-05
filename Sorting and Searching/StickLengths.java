import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickLengths {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long median = arr[(n-1)/2];
        long ans = 0;
        for(int i : arr) {
            ans += Math.abs(i - median);
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
