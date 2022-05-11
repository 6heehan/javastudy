package alg.acmicpc;

import java.util.Scanner;

public class Problem1152 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/1152
        // 단어의 개수

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int cnt = 1;
        for(int i = 1; i<str.length()-1; i++) {
            // 맨 처음, 맨 마지막 공백인 경우 예외 처리 필요
            if(str.charAt(i) == ' ' ) cnt++;
        }
        if(str.length()==1 && str.charAt(0) == ' ') cnt = 0;
        // 공백만 입력 받은 경우 예외 처리 필요
        System.out.println(cnt);
        sc.close();
    }
}
