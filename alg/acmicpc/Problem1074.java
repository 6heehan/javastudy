package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1074 {
    // https://www.acmicpc.net/problem/1074
    // Z

    static int cnt = 0;
    static int r;
    static int c;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        check(0, 0, (int) Math.pow(2, n));
        System.out.println(cnt);
    }

    static void check(int y, int x, int s) {
        if (s == 2) {
            cnt = cnt + (c - x) + (r - y) * 2;
            return;
        }
        int size = s / 2;
        if (y + size > r && x + size > c) {
            // 1사분면
            check(y, x, size);
        } else if (y + size > r && x + size * 2 > c) {
            // 2사분면
            cnt = cnt + size * size;
            check(y, x + size, size);
        } else if (y + size * 2 > r && x + size > c) {
            // 3사분면
            cnt = cnt + size * size * 2;
            check(y + size, x, size);
        } else {
            // 4사분면
            cnt = cnt + size * size * 3;
            check(y + size, x + size, size);
        }

        /*
         * for (int i = 0; i < size / 2; i++) {
         * for (int j = 0; j < size / 2; j++) {
         * if (flag)
         * break;
         * count(y + i * 2, x + j * 2);
         * }
         * }
         * 
         * for (int i = 0; i < size / 2; i++) {
         * for (int j = 0; j < size / 2; j++) {
         * if (flag)
         * break;
         * count(y + i * 2, x + size + j * 2);
         * }
         * }
         * 
         * for (int i = 0; i < size / 2; i++) {
         * for (int j = 0; j < size / 2; j++) {
         * if (flag)
         * break;
         * count(y + size + i * 2, x + j * 2);
         * }
         * }
         * 
         * for (int i = 0; i < size / 2; i++) {
         * for (int j = 0; j < size / 2; j++) {
         * if (flag)
         * break;
         * count(y + size + i * 2, x + size + j * 2);
         * }
         * }
         */
    }

    /*
     * static void count(int y, int x) {
     * for (int i = 0; i < 2; i++) {
     * for (int j = 0; j < 2; j++) {
     * if (y + i == r && x + j == c) {
     * flag = true;
     * return;
     * }
     * cnt++;
     * }
     * }
     * }
     */
}
