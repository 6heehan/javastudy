package alg.acmicpc;

import java.util.Scanner;

public class Problem17626 {
    // https://www.acmicpc.net/problem/17626
    // Four Squares

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(solve(n));
        sc.close();
    }

    static int solve(int num) {
        for (int i = 2; i <= num; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        return dp[num];
    }
}
