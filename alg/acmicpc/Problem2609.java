package alg.acmicpc;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem2609 {
    // https://www.acmicpc.net/problem/2609
    // 최대공약수와 최소공배수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        BigInteger b1 = BigInteger.valueOf(num1);
        BigInteger b2 = BigInteger.valueOf(num2);
        
        System.out.println(b1.gcd(b2).intValue());
        System.out.println((num1 * num2) / b1.gcd(b2).intValue() );
        
        sc.close();
    }
}
