import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Labyrinth {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'A') {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        Node[][] parent = new Node[n][m];

        queue.offer(new Node(startX, startY, -1));
        visited[startX][startY] = true;

        Node destination = null;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (map[node.x][node.y] == 'B') {
                destination = node;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, k));
                    parent[nx][ny] = node;
                }
            }
        }

        if (destination != null) {
            System.out.println("YES");
            StringBuilder path = new StringBuilder();
            Node current = destination;
            while (current.dir != -1) {
                path.append(dir[current.dir]);
                current = parent[current.x][current.y];
            }

            System.out.println(path.length());
            System.out.println(path.reverse().toString());
        } else {
            System.out.println("NO");
        }
    }
}

class Node {
    int x, y, dir;
    Node(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
