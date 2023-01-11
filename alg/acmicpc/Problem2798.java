package alg.acmicpc;

import java.util.Scanner;

public class Problem2798 {
    // https://www.acmicpc.net/problem/2798
    // 블랙잭

    public static void main(String[] args0) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int sum = 0;
        int res = 0;
        int[] num = new int[M];
        for(int i =0 ; i < N; i++) {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i<N-2; i++) {
            sum = 0;
            sum += num[i];
            for(int j=i+1; j<N-1; j++) {
                sum += num[j];
                for(int k=j+1; k<N; k++) {
                    sum += num[k];
                    if(sum <= M) {
                        res = Math.max(res, sum);
                    }
                    sum -= num[k];
                }
                sum -= num[j];
            }
        }
        System.out.println(res);
        sc.close();
    }
}
