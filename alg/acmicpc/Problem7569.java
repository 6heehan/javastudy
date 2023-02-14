package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7569 {
    // https://www.acmicpc.net/problem/7569
    // 토마토

    static int[] dx = { 1, 0, -1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dh = { 0, 0, 0, 0, 1, -1 };

    static int m;
    static int n;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[n][m][h];
        Queue<Tomato> q = new LinkedList<>();
        int zeroCnt = 0;
        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    tomato[j][k][i] = temp;
                    if (temp == 0) {
                        zeroCnt++;
                    } else if (temp == 1) {
                        q.offer(new Tomato(k, j, i, 0));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato t = q.poll();
            int currentX = t.x;
            int currentY = t.y;
            int currentH = t.h;
            int currentD = t.day;

            for (int i = 0; i < 6; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                int nextH = currentH + dh[i];
                int nextD = currentD + 1;

                if (!isValid(nextX, nextY, nextH))
                    continue;

                if (tomato[nextY][nextX][nextH] == 0) {
                    q.offer(new Tomato(nextX, nextY, nextH, nextD));
                    tomato[nextY][nextX][nextH] = 1;
                    res = nextD;
                    zeroCnt--;
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.println(res);
        } else {
            System.out.println("-1");
        }

    }

    static boolean isValid(int x, int y, int height) {
        if (x >= 0 && x < m && y >= 0 && y < n && height >= 0 && height < h)
            return true;
        return false;
    }

    static class Tomato {
        int x;
        int y;
        int h;
        int day;

        public Tomato() {

        }

        public Tomato(int x, int y, int h, int day) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
        }
    }
}
