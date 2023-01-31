package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1012 {
    // https://www.acmicpc.net/problem/1012
    // 유기농 배추

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            int[] mapX = new int[k];
            int[] mapY = new int[k];
            int cnt = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                mapX[j] = x;
                mapY[j] = y;
                map[y][x] = 1;
            }

            for (int j = 0; j < k; j++) {
                int tempX = mapX[j];
                int tempY = mapY[j];

                if (map[tempY][tempX] == 0) {
                    continue;
                }

                map[tempY][tempX] = 0;
                cnt++;
                move(tempY, tempX, map);
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static boolean checkIdx(int y, int x, int mapY, int mapX) {
        if (mapY > y && mapX > x && x >= 0 && y >= 0)
            return true;
        return false;
    }

    static void move(int y, int x, int[][] map) {
        int h = map.length;
        int w = map[0].length;

        for (int a = 0; a < 4; a++) {
            int nextX = x + dx[a];
            int nextY = y + dy[a];

            if (!checkIdx(nextY, nextX, h, w))
                continue;

            if (map[nextY][nextX] == 1) {
                map[nextY][nextX] = 0;
                move(nextY, nextX, map);
            }
        }
    }
}
