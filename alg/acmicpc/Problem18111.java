package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18111 {
    // https://acmicpc.net/problem/18111
    // 마인크래프트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int[][] g = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                g[i][j] = temp;
                sum += temp;
                min = Math.min(min, temp);
            }
        }

        int res = Integer.MAX_VALUE;
        int height = 0;
        for (int i = min; i <= (sum + b) / (n * m); i++) {
            int tempRes = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (g[j][k] > i) {
                        tempRes += (g[j][k] - i) * 2;
                    } else if (g[j][k] < i) {
                        tempRes += i - g[j][k];
                    }
                }
            }

            res = Math.min(res, tempRes);
            if (res >= tempRes) {
                height = i;
            }
        }

        System.out.println(res + " " + height);

    }

}
