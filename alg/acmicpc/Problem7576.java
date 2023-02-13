package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7576 {
    // https://www.acmicpc.net/problem/7576
    // 토마토

    static int[][] tomato;
    static int m;
    static int n;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        int zeroCnt = 0;

        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.offer(new Tomato(i, j, day));
                } else if (tomato[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }

        while (!q.isEmpty()) {
            if (zeroCnt == 0)
                break;

            Tomato t = q.poll();

            int cx = t.x;
            int cy = t.y;
            int cd = t.day;

            for (int i = 0; i < 4; i++) {
                int nextX = cx + dx[i];
                int nextY = cy + dy[i];
                if (isValid(nextY, nextX) && tomato[nextY][nextX] == 0) {
                    q.offer(new Tomato(nextY, nextX, cd + 1));
                    tomato[nextY][nextX] = 1;
                    day = cd + 1;
                    zeroCnt--;
                }
            }

        }

        if (zeroCnt == 0) {
            System.out.println(day);
        } else {
            System.out.println("-1");
        }

    }

    static boolean checkTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < m)
            return true;
        return false;
    }

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato() {

        }

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
