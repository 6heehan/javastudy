package alg.acmicpc;

import java.util.Scanner;

public class Problem8958 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/8958
        // 음계

        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine();
        StringBuffer sb = new StringBuffer();
        while(T > 0) {
            String str = sc.nextLine();
            int sum = 0;
            int cnt = 0;
            for(int i =0; i < str.length(); i++) {
                if(str.charAt(i) == 'O') {
                    cnt++;
                    sum += cnt;
                } else {
                    cnt = 0;
                }
            }
            sb.append(sum);
            sb.append('\n');
            T--;
        }
        System.out.println(sb);
        sc.close();
    }
}
