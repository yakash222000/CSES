package Introductory_Problems;

import java.util.Scanner;

public class GridPaths {

    static boolean[][] onPath = new boolean[9][9];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] p = new int[48];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        for (int i = 0; i < p.length; i++) {
            char cur = line.charAt(i);

            if (cur == 'U') p[i] = 0;
            else if (cur == 'R') p[i] = 1;
            else if (cur == 'D') p[i] = 2;
            else if (cur == 'L') p[i] = 3;
            else p[i] = 4;  // cur == '?'
        }

        for (int i = 0; i < 9; i++) {
            onPath[0][i] = true;
            onPath[8][i] = true;
            onPath[i][0] = true;
            onPath[i][8] = true;
        }

        int ans = tryPath(0, 1, 1);
        System.out.println(ans);
    }

    public static int tryPath(int pathIdx, int curR, int curC) {
        if ((onPath[curR][curC - 1] && onPath[curR][curC + 1]) &&
                (!onPath[curR - 1][curC] && !onPath[curR + 1][curC]))
            return 0;
        if ((onPath[curR - 1][curC] && onPath[curR + 1][curC]) &&
                (!onPath[curR][curC - 1] && !onPath[curR][curC + 1]))
            return 0;

        if (curR == 7 && curC == 1) {
            if (pathIdx == p.length) return 1;
            return 0;
        }
        if (pathIdx == p.length) return 0;

        int ret = 0;
        onPath[curR][curC] = true;

        if (p[pathIdx] < 4) {
            int nxtR = curR + dr[p[pathIdx]];
            int nxtC = curC + dc[p[pathIdx]];
            if (!onPath[nxtR][nxtC]) { ret += tryPath(pathIdx + 1, nxtR, nxtC); }
        }
        else if ((curC > 2) && onPath[curR][curC - 2] &&
                (onPath[curR - 1][curC - 1] || onPath[curR + 1][curC - 1]) &&
                (!onPath[curR][curC - 1])) {
            int nxtR = curR;
            int nxtC = curC - 1;
            ret += tryPath(pathIdx + 1, nxtR, nxtC);
        } else if ((curC < 6) && onPath[curR][curC + 2] &&
                (onPath[curR - 1][curC + 1] || onPath[curR + 1][curC + 1]) &&
                (!onPath[curR][curC + 1])) {
            int nxtR = curR;
            int nxtC = curC + 1;
            ret += tryPath(pathIdx + 1, nxtR, nxtC);
        } else if ((curR > 2) && onPath[curR - 2][curC] && onPath[curR - 1][curC - 1] &&
                (!onPath[curR - 1][curC])) {
            int nxtR = curR - 1;
            int nxtC = curC;
            ret += tryPath(pathIdx + 1, nxtR, nxtC);
        }
        else {
            for (int i = 0; i < 4; i++) {
                int nxtR = curR + dr[i];
                int nxtC = curC + dc[i];
                if (onPath[nxtR][nxtC]) continue;
                ret += tryPath(pathIdx + 1, nxtR, nxtC);
            }
        }

        onPath[curR][curC] = false;
        return ret;
    }
}