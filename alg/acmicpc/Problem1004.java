package alg.acmicpc;

import java.util.Scanner;

public class Problem1004 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/1004
        // 어린 왕자

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int res = 0;

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int r = sc.nextInt();

                boolean start = check(x1, y1, x, y, r);
                boolean end = check(x2, y2, x, y, r);

                if (!(start && end) && (start || end)) {
                    res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
        sc.close();

    }

    static boolean check(int xo, int yo, int x, int y, int r) {
        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < r;
    }
}
