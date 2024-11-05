import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CollectingNumbers {
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
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(!set.contains(arr[i]-1)){
                count++;
            }
            set.add(arr[i]);
        }
        bw.write(count + "\n");
        bw.flush();
    }
}
