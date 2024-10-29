import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;


public class CreatingStrings {

    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        char[] arr = s.toCharArray();

        Arrays.sort(arr);
        set.add(String.valueOf(arr));

        while (nextPermutation(arr)){
            set.add(String.valueOf(arr));
        }

        bw.write(set.size()+"\n");

        Iterator<String> it = set.iterator();

        while (it.hasNext()){
            bw.write(it.next()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static boolean nextPermutation(char[] arr){
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }
        if(i<0) return false;
        int j = arr.length - 1;
        while(arr[i] >= arr[j]){
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i+1, arr.length-1);
        return true;
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int i, int j){
        while(i<j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
