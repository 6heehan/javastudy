package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1929 {
    public static void main(String[] args) throws Exception {
        // https://www.acmicpc.net/problem/1929
        // 소수 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        /*
         * for(int i = M; i <= N; i++) {
         * boolean flag = false;
         * for(int j=2; j<i; j++) {
         * BigInteger num = BigInteger.valueOf(i);
         * if(num.gcd(BigInteger.valueOf(j)).intValue() > 1)
         * flag = true;
         * }
         * 
         * if(!flag)
         * sb.append(i).append('\n');
         * }
         */

        for (int i = M; i <= N; i++) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (i < 2)
                flag = true;
            if (!flag)
                sb.append(i).append('\n');
        }

        System.out.println(sb);
    }
}
