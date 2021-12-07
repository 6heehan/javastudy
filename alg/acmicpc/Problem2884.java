package alg.acmicpc;

import java.util.Scanner;

public class Problem2884 {
    public static void main(String[] args) {

        System.out.println("알람 시계");
        System.out.println("https://www.acmicpc.net/problem/2884");


        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        //System.out.println(H + " " + M);
        sc.close();

        if(M >= 45) {
            System.out.println(H + " " + (M-45));
        } else if(H == 0) {
            H = 23;
            System.out.println(H + " " + (60 + M-45));
        } else {
            System.out.println((H-1) + " " + (60 + M-45));
        }
    }
}
