package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6064 {
    // https://www.acmicpc.net/problem/6064
    // 카잉 달력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // int cx = 1;
            // int cy = 1;
            // int res = 1;
            /*
             * while (true) {
             * if (cx == x && cy == y)
             * break;
             * 
             * if (cx == 1 && cy == 1 && res != 1) {
             * res = -1;
             * break;
             * }
             * 
             * cx++;
             * cy++;
             * res++;
             * if (cx > m) {
             * cx = 1;
             * }
             * if (cy > n) {
             * cy = 1;
             * }
             * }
             */

            int loopCnt = n * m / getGcd(m, n) / m;

            boolean flag = false;
            for (int j = 0; j < loopCnt; j++) {
                int cnt = m * j + x;
                if (cnt % n == y) {
                    sb.append(cnt).append(" ");
                    flag = true;
                    break;
                } else if (cnt % n == 0 && y == n) {
                    sb.append(cnt).append(" ");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("-1 ");
            }

            // sb.append(res).append(" ");
        }

        System.out.println(sb);
    }

    static int getGcd(int num1, int num2) {

        while (num2 != 0) {
            int r = num1 % num2;

            num1 = num2;
            num2 = r;
        }
        return num1;
    }
}
