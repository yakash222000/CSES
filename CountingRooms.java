import java.util.Scanner;
import java.util.Stack;

public class CountingRooms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == '.' && !visited[i][j]) {
                    iterativeDFS(map, visited, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void iterativeDFS(char[][] map, boolean[][] visited, int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0];
            int y = cell[1];
            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                if (newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length &&
                        map[newX][newY] == '.' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    stack.push(new int[]{newX, newY});
                }
            }
        }
    }
}
