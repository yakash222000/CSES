package Graph_Algorithms;

import java.io.*;
import java.util.*;

public class MessageRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            connections.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            connections.get(a).add(b);
            connections.get(b).add(a);
        }

        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        boolean check = false;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == n){
                check = true;
                break;
            }
            for(int neighbor : connections.get(cur)){
                if(!visited[neighbor]){
                    parent[neighbor] = cur;
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        if(check){
            List<Integer> path = new ArrayList<>();
            for (int v = n; v != -1; v = parent[v]) {
                path.add(v);
            }
            Collections.reverse(path);
            bw.write(path.size()+"\n");
            for(int v : path){
                bw.write(v+" ");
            }
        }
        else bw.write("IMPOSSIBLE\n");
        bw.flush();
        bw.close();

    }
}
