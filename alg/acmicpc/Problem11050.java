package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11050 {
    // https://www.acmicpc.net/problem/11050
    // 이항 계수1

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) / (factorial(N-K) * factorial(K)));
    }

    static int factorial(int n) {
        if(n <= 1) 
            return 1;
        return n * factorial(n -1);
    }
}
