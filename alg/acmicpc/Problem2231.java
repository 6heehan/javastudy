package alg.acmicpc;

import java.util.Scanner;

public class Problem2231 {
    // https://www.acmicpc.net/problem/2231
    // 분해합

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        for(int i = 0 ; i < N ; i++) {
            int num = i;
            int sum = 0;

            while(num != 0) {
                sum = sum + num % 10;
                num = num / 10;
            }

            if(sum + i == N) {
                res = i;
                break;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
