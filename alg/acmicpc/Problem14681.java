package alg.acmicpc;

import java.util.Scanner;

public class Problem14681 {
    public static void main(String[] args) {

        System.out.println("사분면 고르기");
        System.out.println("https://www.acmicpc.net/problem/14681");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        int answer = 0;
        if(x > 0 && y > 0)
            answer = 1;
        else if(x > 0 && y < 0)
            answer = 4;
        else if(x < 0 && y > 0) 
            answer = 2;
        else
            answer = 3;

        System.out.println(answer);
    }
}
