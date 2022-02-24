package alg.acmicpc;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem1271 {
    public static void main(String[] args) {
        System.out.println("https://www.acmicpc.net/problem/1271");
        System.out.println("엄청난 부자2");

        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();

        System.out.println(n.divide(m));
        System.out.println(n.remainder(m));
        
        sc.close();
    }
}