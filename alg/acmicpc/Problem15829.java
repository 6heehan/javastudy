package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem15829 {
    public static void main(String[] args) throws Exception {
        // https://www.acmicpc.net/problem/15829
        // Hashing

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int m = 1234567891;
        int r = 31;

        double res = 0;
        double pow = 1;
        for(int i = 0; i < L; i++) {
            char tempC = input.charAt(i);
            int tempI = tempC - 96;
            res = res + tempI * pow % m;
            pow = pow * r % m;
        }
        res = res % m;
        System.out.println((int)res);
    }
}
