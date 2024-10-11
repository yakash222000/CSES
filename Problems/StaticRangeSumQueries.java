package Problems;

import java.io.*;

public class StaticRangeSumQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLineParts = br.readLine().trim().split(" ");
        int n = Integer.parseInt(firstLineParts[0]);
        int q = Integer.parseInt(firstLineParts[1]);

        long[] prefixSum = new long[n + 1]; // Size n + 1 to store sums

        String[] valuesParts = br.readLine().trim().split(" ");
        for (int i = 1; i <= n; i++) {
            long value = Long.parseLong(valuesParts[i - 1]); // Read the value
            prefixSum[i] = prefixSum[i - 1] + value; // Compute the prefix sum
        }

        for (int i = 0; i < q; i++) {
            String[] queryParts = br.readLine().trim().split(" ");
            int a = Integer.parseInt(queryParts[0]);
            int b = Integer.parseInt(queryParts[1]);

            long sum = prefixSum[b] - prefixSum[a - 1];
            bw.write(sum + "\n");
        }

        // Flush and close the BufferedWriter
        bw.flush();
        bw.close();
        br.close();
    }
}
