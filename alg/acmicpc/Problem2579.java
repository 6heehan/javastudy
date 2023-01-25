package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2579 {
    // https://www.acmicpc.net/problem/2579
    // 계단 오르기

    static int[] dp;
    static int[] stair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stair = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stair[0];
        dp[1] = stair[1];

        if (n >= 2) {
            dp[2] = stair[1] + stair[2];
        }

        System.out.println(find(n));

    }

    static int find(int n) {
        if (dp[n] == 0 && n != 0) {
            dp[n] = Math.max(find(n - 2), find(n - 3) + stair[n - 1]) + stair[n];
        }

        return dp[n];
    }
}
