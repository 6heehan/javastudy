package alg.acmicpc;

import java.util.Scanner;

public class Problem1094 {
    public static void main(String[] args) {
        System.out.println("https://www.acmicpc.net/problem/1094");
        System.out.println("막대기");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int stick = 64;
        int remainStick = 0;
        int count = 0;
        while(remainStick != x) {
            count++;
            stick = stick - stick / 2;
            if(stick + remainStick <= x) {
                remainStick = remainStick + stick;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
