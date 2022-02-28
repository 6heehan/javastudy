package alg.acmicpc;

import java.util.Scanner;

public class Problem2420 {
    public static void main(String[] args) {
        System.out.println("https://www.acmicpc.net/problem/2420");
        System.out.println("사파리월드");

        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();

        System.out.println(Math.abs(a-b));
        //System.out.printf("%.0f",Math.abs((double)(a-b)));
        sc.close();
    }
}
