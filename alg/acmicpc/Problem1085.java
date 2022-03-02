package alg.acmicpc;

import java.util.Scanner;

public class Problem1085 {
    public static void main(String[] args) {
        System.out.println("https://www.acmicpc.net/problem/1085");
        System.out.println("직사각형에서 탈출");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int xMin = Math.min(w-x, x);
        int yMin = Math.min(h-y, y);
        System.out.println(Math.min(xMin, yMin));
        sc.close();
    }
}
