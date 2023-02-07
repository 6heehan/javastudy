package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2178 {
    // https://www.acmicpc.net/problem/2178
    // 미로 탐색

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        map[0][0] = 0;

        Queue<Cord> q = new LinkedList<>();
        q.offer(new Cord(0, 0, 1));

        while (!q.isEmpty()) {
            Cord c = q.poll();
            int y = c.y;
            int x = c.x;
            int count = c.cnt;
            if (y == n - 1 && x == m - 1) {
                System.out.println(count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];
                if (isValid(nextY, nextX) && map[nextY][nextX] == 1) {
                    q.offer(new Cord(nextY, nextX, count + 1));
                    map[nextY][nextX] = 0;
                    // queue 에 넣을 좌표를 방문했다고 표시해줘야함.
                    // 메모리 초과 발생
                }
            }
        }
    }

    static boolean isValid(int y, int x) {
        if (y >= 0 && y < n && x >= 0 && x < m) {
            return true;
        }
        return false;
    }

    static class Cord {
        int x;
        int y;
        int cnt;

        public Cord() {

        }

        public Cord(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
