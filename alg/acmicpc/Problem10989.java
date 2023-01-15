package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem10989 {
    // https://www.acmicpc.net/problem/10989
    // 수 정렬하기 3

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
            //System.out.println(num[i]);
            sb.append(num[i]).append('\n');
        }

        System.out.println(sb);

        System.out.println("====");

        int[] cnt = new int[10001];
        for(int i=0; i<N; i++) {
            cnt[num[i]]++;
        }
        for(int i=1; i<10001; i++) {
            for(int j=0; j<cnt[i]; j++) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
