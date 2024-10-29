import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHanoi {
    static int count = 0;
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        printTowerOfHanoi(n,1,2,3);

        bw.write(ans.size()+"\n");

        for(int i=0;i<ans.size();i++){
            bw.write(ans.get(i).get(0)+" "+ans.get(i).get(1)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void printTowerOfHanoi(int n, int source, int auxiliary, int destination) {
        if (n == 1) {
            ans.add(new ArrayList<>(Arrays.asList(source, destination)));
            return;
        }
        printTowerOfHanoi(n-1, source, destination, auxiliary);

        ans.add(new ArrayList<>(Arrays.asList(source, destination)));

        printTowerOfHanoi(n-1, auxiliary, source, destination);
    }
}
