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
        
        int sum = 0;

        int[] line = new int[K];

        for(int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            sum += line[i];
        }
        
        int cnt = N;
        int ans = sum / N;
        int tempSum = 0;
        for(int i =0; i < K; i++) {
            tempSum += line[i] / ans;
        }

        if(tempSum < N) {
            while(tempSum != N) {
                ans--;
                for(int i =0; i < K; i++) {
                    tempSum += line[i] / ans;
                }       
            }
        } else {
            while(tempSum > N) {
                ans++;
                for(int i =0; i < K; i++) {
                    tempSum += line[i] / ans;
                }
            }
        }

        System.out.println(ans);
    }
}
