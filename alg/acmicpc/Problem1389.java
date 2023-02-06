package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1389 {
    // https://www.acmicpc.net/problem/1389
    // 케빈 베이컨의 6단계 법칙

    static int[][] f;
    static boolean[] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        f = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            f[f1][f2] = 1;
            f[f2][f1] = 1;
        }

        int res = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            visit = new boolean[n + 1];
            int tempRes = check(i);
            if (tempRes < res) {
                res = tempRes;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static int check(int num) {
        int sum = 0;
        Queue<Data> q = new LinkedList<>();
        visit[num] = true;
        q.offer(new Data(num, 0));

        while (!q.isEmpty()) {
            Data d = q.poll();
            sum += d.value;

            for (int i = 1; i <= n; i++) {
                int temp = f[d.num][i];

                if (temp == 1 && visit[i] == false) {
                    visit[i] = true;
                    q.offer(new Data(i, d.value + 1));
                }
            }
        }

        return sum;
    }

    static class Data {
        int value;
        int num;

        public Data() {

        }

        public Data(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
