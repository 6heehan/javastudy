package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // System.out.println(pumutation(n, m) / factorial(m));

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        System.out.println(n1.divide(n2));
    }

    static double pumutation(int n, int m) {
        double res = 1;
        for (int i = n; i > m; i--) {
            res = res * i;
        }
        return res;
    }

    static double factorial(int n) {
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
}
