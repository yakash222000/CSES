import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr1 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Arrays.sort(arr1);

        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            if (arr[i] - k <= arr1[j] && arr[i] + k >= arr1[j]) {
                count++;
                i++;
                j++;
            } else if (arr1[j] < arr[i] - k) {
                // If arr1[j] is too small, move j forward
                j++;
            } else {
                // If arr[i] is too small for arr1[j], move i forward
                i++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
    }
}
