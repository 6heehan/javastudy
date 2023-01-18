package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2751 {
    // https://www.acmicpc.net/problem/2751
    // 수 정렬하기 2

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        for(int i=0; i<N; i++) {
            sb.append(num[i]).append('\n');
        }
        System.out.println(sb);
    }
}
