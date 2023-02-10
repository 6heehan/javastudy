package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11403 {
    // https://www.acmicpc.net/problem/11403
    // 경로 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] g = new int[n][n];
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    q.offer(j);
                    res[i][j] = 1;
                }
            }
            boolean[] isVisted = new boolean[n];
            while (!q.isEmpty()) {
                int next = q.poll();
                for (int j = 0; j < n; j++) {
                    if (i == next)
                        break;
                    if (isVisted[j])
                        continue;
                    if (g[next][j] == 1) {
                        q.offer(j);
                        isVisted[j] = true;
                        res[i][j] = 1;
                        res[next][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
