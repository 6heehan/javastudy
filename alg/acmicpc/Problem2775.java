package alg.acmicpc;

import java.util.Scanner;

public class Problem2775 {
    // https://www.acmicpc.net/problem/2775
    // 부녀회장이 될테야

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int res[] = new int[T];
        for(int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int p[][] = new int[n][k+1];
            
            for(int j = 0; j < n; j++) {
                for(int l = 0; l <= k; l++) {
                    if(j == 0) {
                        p[j][l] = 1;
                    } else if(l == 0) {
                        p[j][l] = j+1;
                    } else {
                        p[j][l] = p[j-1][l] + p[j][l-1];
                    }
                }
            }
            res[i] = p[n-1][k];
        }
        for(int i=0; i < T; i++) {
            System.out.println(res[i]);
        }
        sc.close();
    }
}
