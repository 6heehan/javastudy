package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1654 {
    public static void main(String[] args) throws Exception{
        // https://www.acmicpc.net/problem/1654
        // 랜선 자르기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // int sum = 0;

        int[] line = new int[K];
        long max = 0;
        
        for(int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            // sum += line[i];
            if(max < line[i])
                max = line[i];
        }

        max++;

        long min = 0;
        long mid = 0;

        while(min < max) {
            mid = (min + max) /2;
            long count = 0;

            for(int i = 0; i < K; i++) {
                count += (line[i] / mid);
            }

            if(count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        System.out.println(min - 1);
        // int cnt = N;
        // int ans = sum / N;
        // int tempSum = 0;
        // for(int i =0; i < K; i++) {
        //     tempSum += line[i] / ans;
        // }

        // if(tempSum < N) {
        //     while(tempSum != N) {
        //         tempSum = 0;
        //         ans--;
        //         for(int i =0; i < K; i++) {
        //             tempSum += line[i] / ans;
        //         }       
        //     }
        // } else {
        //     // tempSum >=
        //     while(tempSum >= N) {
        //         tempSum = 0;
        //         ans++;
        //         for(int i =0; i < K; i++) {
        //             tempSum += line[i] / ans;
        //         }
        //     }
        //     ans--;
        // }

        // System.out.println(ans);
    }
}
