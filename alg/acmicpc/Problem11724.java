package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11724 {
    // https://www.acmicpc.net/problem/11724
    // 연결 요소의 개수

    static int[][] check;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        check = new int[1001][1001];
        checked = new boolean[1001];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            check[u][v] = 1;
            check[v][u] = 1;
        }

        int cnt = 0;

        for (int k = 1; k <= n; k++) {
            if (!checked[k]) {
                dfs(k, n);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int i, int n) {
        checked[i] = true;
        for (int j = 1; j <= n; j++) {
            if (check[i][j] == 1 && !checked[j]) {
                dfs(j, n);
            }
        }
    }
}
