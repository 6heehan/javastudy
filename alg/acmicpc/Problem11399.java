package alg.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem11399 {
    public static void main(String[] agrs) {
        System.out.println("ATM");
        System.out.println("https://www.acmicpc.net/problem/11399");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];

        for(int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int answer = 0;
        for(int i=0;i<N;i++) {
            for(int j=i;j<N;j++) {
                answer = answer + P[i];
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
