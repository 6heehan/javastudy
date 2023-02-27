package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem16236 {
    // https://www.acmicpc.net/problem/16236
    // 아기 상어

    static int n;
    static int[][] map;

    static int cX;
    static int cY;
    static int nX;
    static int nY;

    static int[] dx = { 0, -1, 1, 0 };
    static int[] dy = { -1, 0, 0, 1 };

    static int size = 2;
    static int cnt = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cX = j;
                    cY = i;
                    map[i][j] = 0;
                }
            }
        }

        find();
        System.out.println(time);

    }

    static void find() {
        PriorityQueue<Data> q = new PriorityQueue<>(Collections.reverseOrder());
        boolean[][] visited = new boolean[n][n];

        q.offer(new Data(cY, cX, 0));
        visited[cY][cX] = true;

        while (!q.isEmpty()) {
            Data data = q.poll();
            int y = data.y;
            int x = data.x;
            int d = data.d;

            if (map[y][x] < size && map[y][x] > 0) {
                time += d;
                cY = y;
                cX = x;
                cnt++;
                map[cY][cX] = 0;
                if (cnt == size) {
                    size++;
                    cnt = 0;
                }
                find();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if (nextY >= n || nextX >= n || nextY < 0 || nextX < 0) {
                    continue;
                }

                if (map[nextY][nextX] <= size && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    q.offer(new Data(nextY, nextX, d + 1));
                }
            }
        }
    }

    static class Data implements Comparable<Data> {
        int y;
        int x;
        int d;

        public Data() {

        }

        public Data(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(Data o) {
            if (this.d < o.d) {
                return 1;
            } else if (this.d == o.d) {
                if (this.y < o.y) {
                    return 1;
                } else if (this.y == o.y) {
                    if (this.x < o.x) {
                        return 1;
                    } else if (this.x == o.x) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}
