package alg.acmicpc;

import java.util.Scanner;

public class Problem2606 {

    static int map[][];
    static boolean visit[];
    static int n,m,v;
    static int count = 0;

    public static int dfs(int i) {
        visit[i] = true;

        for(int j=1; j<=n; j++) {
            if(map[i][j] == 1 && visit[j] == false) {
                count++;
                dfs(j);
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println("바이러스");
        System.out.println("https://www.acmicpc.net/problem/2606");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = 1;

        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b=  sc.nextInt();

            map[a][b] = map[b][a] = 1;
        }

        System.out.println(dfs(1));
        sc.close();
    }
}
