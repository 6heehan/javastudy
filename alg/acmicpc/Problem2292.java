package alg.acmicpc;

import java.util.Scanner;

public class Problem2292 {
    // https://www.acmicpc.net/problem/2292
    // 벌집

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int sum = 1;

        while(sum < N) {
            sum = count * 6 + sum;
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
