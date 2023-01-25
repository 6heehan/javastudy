package alg.acmicpc;

import java.util.Scanner;

public class Problem9461 {
    // https://www.acmicpc.net/problem/9461
    // 파도반 수열

    static long[] dp = new long[101];
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            // dp = new long[n + 1];
            // arr = new int[n+1];
            dp[0] = -1;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;

            if (n <= 5) {
                sb.append(dp[n]).append("\n");
            } else {
                sb.append(find(n)).append("\n");
            }
        }
        System.out.println(sb);
        sc.close();
    }

    static long find(int n) {
        if (dp[n] == 0) {
            dp[n] = find(n - 1) + find(n - 5);
        }

        return dp[n];
    }
}
