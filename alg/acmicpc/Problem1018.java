package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1018 {
    // https://acmicpc.net/problem/1018
    // 체스판 다시 칠하기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        

        char[][] c = new char[N][M];

        System.out.println(N + M);
        // System.out.println(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] test = st.nextToken().split("");
            int index = 0;
            for(String s: test) {
                c[i][index] = s.charAt(0);
                index++;
            }
        }
    }
}
