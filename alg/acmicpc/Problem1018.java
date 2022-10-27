package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1018 {
    // https://acmicpc.net/problem/1018
    // 체스판 다시 칠하기

    static int ans = Integer.MAX_VALUE;
    static char[][] c;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        

        c = new char[N][M];

        // System.out.println(N + M);
        // System.out.println(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] test = st.nextToken().split("");
            int index = 0;
            for(String s: test) {
                c[i][index] = s.charAt(0);
                index++;
            }
        }
        
        int x = 0;
        int y = 0;
        while(N != y) {
            if(x+7 <= M-1 && y+7 <= N-1)
                calc(x,y);
            x++;
            if(x == M) {
                x = 0;
                y++;
            }
        }
        // System.out.println("answer : ");
        System.out.println(ans);
    }
    
    public static void calc(int x, int y) {
        int c_x = x;
        int c_y = y;
        int cnt = 0;
        char[][] temp = new char[c.length][c[0].length];

        for(int i = 0; i < c.length; i++) {
            // System.arraycopy(c[i], 0, temp, 0, c[i].length);
            temp[i] = c[i].clone();
        }

        while(true) {
            char temp1 = temp[c_y][c_x];
            c_x++;
            if(c_x == x+8) {
                c_x = x;
                temp1 = temp[c_y][c_x];
                c_y++;
                if(c_y == y+8)
                    break;    
            }

            char temp2 = temp[c_y][c_x];
            
            if(temp1 == temp2) {
                // System.out.println("cnt : " + cnt + " temp1 : " + temp1 + " temp2 : " + temp2);
                cnt++;
                if(temp1 == 'B')
                    temp[c_y][c_x] = 'W';
                else 
                    temp[c_y][c_x] = 'B';
            }
        }
        // System.out.println("y : " + y + " x : " + x);
        // System.out.println("cnt : " + cnt);
        cnt = Math.min(cnt, 64-cnt);
        ans = Math.min(cnt, ans);
    }
}
