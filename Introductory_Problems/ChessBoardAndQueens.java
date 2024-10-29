package Introductory_Problems;

import java.util.Scanner;

public class ChessBoardAndQueens {
    static final int N = 8;
    static boolean[][] board = new boolean[N][N];
    static boolean[][] input = new boolean[N][N];
    static int ans = 0;

    static boolean place(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (board[x][i] || board[i][y]) return false;
        }
        for (int i = 0; x - i >= 0 && y - i >= 0; i++) {
            if (board[x - i][y - i]) return false;
        }
        for (int i = 0; x - i >= 0 && y + i < N; i++) {
            if (board[x - i][y + i]) return false;
        }
        return true;
    }

    static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] && input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void dfs(int i) {
        if (i == N) {
            if (check()) ans++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if (place(i, j)) {
                board[i][j] = true;
                dfs(i + 1);
                board[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            String line = scanner.next();
            for (int j = 0; j < N; j++) {
                input[i][j] = (line.charAt(j) == '*');
            }
        }
        dfs(0);

        System.out.println(ans);
    }
}
