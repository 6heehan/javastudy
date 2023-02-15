package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10026 {
    // https://www.acmicpc.net/problem/10026
    // 적록색약

    static int n;
    static int[][] map;
    static boolean[][] isVisited;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int RGBCnt = 0;
    static int BCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                char tempC = temp.charAt(j);
                switch (tempC) {
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'G':
                        map[i][j] = 0;
                        break;
                    case 'B':
                        map[i][j] = -1;
                        break;
                }
            }
        }

        // dfs
        int normalCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(j, i);
                    normalCnt++;
                }
            }
        }

        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                }
            }
        }
        int abnormalCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(j, i);
                    abnormalCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + abnormalCnt);

    }

    static void dfs(int x, int y) {
        isVisited[y][x] = true;
        int temp_value = map[y][x];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isValid(nextX, nextY))
                continue;

            if (!isVisited[nextY][nextX] && map[nextY][nextX] == temp_value) {
                dfs(nextX, nextY);
            }
        }
    }

    static void dfsRGB(int x, int y, int value) {
        int blockCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(nextX, nextY) && !isVisited[nextY][nextX] && value == map[nextY][nextX]) {
                isVisited[nextY][nextX] = true;
                dfsRGB(nextX, nextY, value);
                isVisited[nextY][nextX] = false;
            } else if (!isValid(nextX, nextY) || isVisited[nextY][nextX]) {
                blockCnt++;
            }
        }
        if (blockCnt == 4) {
            RGBCnt++;
        }
    }

    static boolean isValid(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n)
            return true;
        return false;
    }
}
