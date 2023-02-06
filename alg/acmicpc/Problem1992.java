package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1992 {
    // https://www.acmicpc.net/problem/1992
    // 쿼드트리

    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }
        partition(0, 0, n);
        System.out.println(sb);
    }

    static boolean check(int y, int x, int size) {
        int value = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (value != map[i][j])
                    return false;
            }
        }
        return true;
    }

    static void partition(int y, int x, int size) {
        if (check(y, x, size)) {
            sb.append(map[y][x]);
            return;
        }
        sb.append("(");
        int newSize = size / 2;
        partition(y, x, newSize);
        partition(y, x + newSize, newSize);
        partition(y + newSize, x, newSize);
        partition(y + newSize, x + newSize, newSize);
        sb.append(")");
    }

}
