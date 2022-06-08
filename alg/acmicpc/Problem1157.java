package alg.acmicpc;

import java.util.Scanner;

public class Problem1157 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/1157
        // 단어 공부

        Scanner sc = new Scanner(System.in);
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        String str = sc.nextLine().toLowerCase().concat(" ");
        int max = 0;
        String result = "";
        for(int i=0; i< alphabet.length();i++) {
            String temp = Character.toString(alphabet.charAt(i));
            int value = str.split(temp).length - 1;
            if(value > max) {
                max = value;
                result = temp.toUpperCase();
            } else if (value == max) {
                result = "?";
            } 
        }
        System.out.println(result);
        sc.close();
    }
}
