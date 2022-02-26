package alg.acmicpc;

import java.util.Scanner;

public class Problem1550 {
    public static void main(String[] args) {

        System.out.println("https://www.acmicpc.net/problem/1550");
        System.out.println("16진수");
        Scanner sc = new Scanner(System.in);

        String data = sc.next();
        int value = Integer.valueOf(data, 16);
        System.out.println(value);

        sc.close();
    }
}
