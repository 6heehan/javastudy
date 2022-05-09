package alg.acmicpc;

import java.util.Scanner;

public class Problem2675 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2675
        // 문자열 반복

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(T > 0) {
            int R = sc.nextInt();
            String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ')
                    continue;
                for(int j = 0; j < R; j++) {
                    sb.append(str.charAt(i));
                }
            }
            sb.append('\n');
            T--;
        }
        System.out.println(sb);
        sc.close();
    }
}
