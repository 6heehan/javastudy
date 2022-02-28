package alg.acmicpc;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem2338 {
    public static void main(String[] args) {
        System.out.println("https://www.acmicpc.net/problem/2338");
        System.out.println("긴자리 계산");

        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        sc.close();
    }
}
