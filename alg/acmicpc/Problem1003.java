package alg.acmicpc;

import java.util.Scanner;

public class Problem1003 {

    static int zero;
    static int one;
    static int zero_plus_one;

    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/1003
        // 피보나치 함수

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            fibonacci1(N);
            sb.append(zero).append(' ').append(one).append('\n');
        }
        System.out.println(sb);
        sc.close();
    }

    static void fibonacci1(int n) {
        zero = 1;
        one = 0;
        zero_plus_one = 1;

        for(int i = 0 ; i < n ; i++) {
            zero = one;
            one = zero_plus_one;
            zero_plus_one = zero + one;
        }
    }
}
