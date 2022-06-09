package alg.acmicpc;

import java.util.Scanner;

public class Problem2908 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/2908
        // 상수

        Scanner sc = new Scanner(System.in);
        String tempString = sc.nextLine();

        String[] temp = tempString.split(" ");
        int num1 = Integer.parseInt(temp[0]);
        int num2 = Integer.parseInt(temp[1]);
        num1 = num1/100 + num1%10*100 + num1%100/10*10;
        num2 = num2/100 + num2%10*100 + num2%100/10*10;
        System.out.println(Math.max(num1,num2));
        sc.close();
    }
}
