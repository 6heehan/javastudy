package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14500 {
    // https://www.acmicpc.net/problem/14500
    // 테트로미노

    static int n;
    static int m;

    static boolean[][] visited;
    static int[][] map;

    static int max = Integer.MIN_VALUE;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                move(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    static void move(int y, int x, int sum, int count) {
        if (count == 4) {
            if (sum > max)
                max = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
                continue;

            if (count == 2 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                move(y, x, sum + map[nextY][nextX], count + 1);
                visited[nextY][nextX] = false;
            }

            if (!visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                move(nextY, nextX, sum + map[nextY][nextX], count + 1);
                visited[nextY][nextX] = false;
            }
        }

    }
}
