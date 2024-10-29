
import java.io.*;
import java.util.*;

public class BuildingRoads {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> roads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            roads.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            roads.get(a).add(b);
            roads.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        List<Integer> components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components.add(i);
                iterativeDFS(roads, visited, i);
            }
        }

        int roadsNeeded = components.size() - 1;
        bw.write(roadsNeeded + "\n");

        for (int i = 1; i < components.size(); i++) {
            bw.write((components.get(0) + 1) + " " + (components.get(i) + 1) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void iterativeDFS(List<List<Integer>> roads, boolean[] visited, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int city = stack.pop();
            for (int neighbor : roads.get(city)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
