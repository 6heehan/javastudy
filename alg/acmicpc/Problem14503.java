package alg.acmicpc;

import java.util.Scanner;

public class Problem14503 {

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    static int N;
    static int M;
    static int[][] map;
    static int cnt = 1;
    static boolean isOver = false;

    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/14503
        // 로봇 청소기

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        map[r][c] = 2;

        move(r, c, d);
        System.out.println(cnt);

        sc.close();
    }

    static void move(int y, int x, int d) {
        boolean isClean = false;
        for (int i = 0; i < 4; i++) {
            int nY = dy[i] + y;
            int nX = dx[i] + x;

            if (nY >= N || nY < 0 || nX < 0 || nX >= M)
                continue;

            if (map[nY][nX] == 0) {
                isClean = true;
                break;
            }
        }

        if (isClean) {
            int nD = d;
            for (int i = 0; i < 4; i++) {
                nD = (nD + 3) % 4;
                int nY = y + dy[nD];
                int nX = x + dx[nD];

                if (nY >= N || nY < 0 || nX < 0 || nX >= M)
                    continue;

                if (map[nY][nX] == 0) {
                    if (map[y][x] == 0) {
                        cnt++;
                        map[y][x] = 2;
                    }
                    move(nY, nX, nD);
                } else if (map[nY][nX] == 2) {
                    continue;
                }

                if (isOver) {
                    break;
                }
            }
        } else {
            int nY = y - dy[d];
            int nX = x - dx[d];

            if (map[nY][nX] == 1) {
                isOver = true;
                return;
            } else if (map[y][x] == 0) {
                cnt++;
                map[y][x] = 2;
                move(nY, nX, d);
            } else if (map[y][x] == 2) {
                move(nY, nX, d);
            }
        }

        if (isOver) {
            return;
        }
    }
}
