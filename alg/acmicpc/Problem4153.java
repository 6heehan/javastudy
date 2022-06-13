package alg.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4153 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/4153
        // 직각삼각형

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int num[] = new int[3];
        num[0] = 1;
        num[1] = 1;
        num[2] = 1;
        while(num[0]!= 0 && num[1]!= 0 && num[2]!=0) {
            num[0] = sc.nextInt();
            num[1] = sc.nextInt();
            num[2] = sc.nextInt();
            if(num[0]== 0 && num[1]== 0 && num[2]==0)
                break;
            
            Arrays.sort(num);   
            if(num[2]*num[2] == num[0]*num[0] + num[1]*num[1]) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
        sc.close();
    }
}
