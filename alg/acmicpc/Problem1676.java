package alg.acmicpc;

import java.util.Scanner;

public class Problem1676 {

    // https://www.acmicpc.net/problem/1676
    // 팩토리얼 0의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
         * double num = factorial(n);
         * int cnt = 0;
         * System.out.println(num);
         * while (num % 10 == 0) {
         * num = num / 10;
         * cnt++;
         * }
         * System.out.println(cnt);
         */
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
        sc.close();
    }

    static double factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
