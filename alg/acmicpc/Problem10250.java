package alg.acmicpc;

import java.util.*;

public class Problem10250 {
    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/10250
        // ACM 호텔

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            // int W = sc.nextInt();
            int N = sc.nextInt();
            // 6층 10번째 손님 -> 402호 10%6 = 4 / 10/6 = 1
            // 6층 3번째 손님 -> 301호 3%6 = 3 / 3/6 = 0
            // 6층 6번째 손님 -> 601호 6%6 = 0 / 6/6 = 1

            if (N % H == 0) {
                sb.append(String.valueOf(100 * H + N / H));
            } else {
                sb.append(String.valueOf(N % H * 100 + N / H + 1));
            }

            // int w = N / H + 1;
            // int h = N % H;
            // if(h == 0) {
            // h = H;
            // }
            // sb.append(String.valueOf(h));
            // if(w < 10) {
            // sb.append("0");
            // }
            // if (w-1 == W) {
            // w = w-1;
            // }
            // sb.append(String.valueOf(w));
            sb.append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
