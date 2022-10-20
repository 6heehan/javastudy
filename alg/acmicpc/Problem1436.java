package alg.acmicpc;

import java.util.Scanner;

public class Problem1436 {
    // https://www.acmicpc.net/problem/1436
    // 영화감독 숌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int num = 666;
        while(true) {
            String temp  = String.valueOf(num);
            if(temp.contains("666")) cnt++;
            if(N == cnt) {
                System.out.println(num);
                break;
            }
            num++;
        }
        sc.close();
    }
}
