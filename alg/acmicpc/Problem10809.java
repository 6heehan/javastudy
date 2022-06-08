package alg.acmicpc;

import java.util.Scanner;

public class Problem10809 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/10809
        // 알파벳 찾기

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < alphabet.length(); i++) {
            char tempChar = alphabet.charAt(i);
            sb.append(str.indexOf(tempChar)).append(" ");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
