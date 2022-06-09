package alg.acmicpc;

import java.util.Scanner;

public class Problem2475 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2475
        // 검증수

        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++) {
            num[i] = sc.nextInt();
            sum += num[i] * num[i];
        }
        System.out.println(sum % 10);
        sc.close();
    }
}