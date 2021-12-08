package alg.acmicpc;

import java.util.Scanner;

public class Problem11047 {
    public static void main(String[] args) {
        System.out.println("동전 0");
        System.out.println("https://www.acmicpc.net/problem/11047");
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        int answer = 0;
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for(int i = N-1 ; i > 0; i--) {
            int tempValue = K / A[i];
            if(tempValue == 0) {
                continue;
            }
            K = K - A[i]*tempValue;
            answer = answer + tempValue;
        }
        System.out.println(answer);
        
        sc.close();
    }
}
