package alg.acmicpc;

import java.util.Scanner;

public class Problem1032 {
    public static void main(String[] args) {
        System.out.println("https://www.acmicpc.net/problem/1032");
        System.out.println("명령 프롬프트");

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n = Integer.valueOf(num);
        String[] fileName = new String[n];
        for(int i = 0; i < n ; i++) {
            fileName[i] = sc.nextLine();
        }
        int len = fileName[0].length();
        String answer = "";
        for(int i = 0; i < len; i++) {
            char temp = fileName[0].charAt(i);
            for(int j = 1; j < n; j++) {
                if(temp != fileName[j].charAt(i)) {
                    temp = '?';
                    break;
                }
            }
            answer = answer + temp;
        }
        System.out.println(answer);
        sc.close();
    }
    
}
