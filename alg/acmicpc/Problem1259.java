package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1259 {
    // https://www.acmicpc.net/problem/1259
    // 팰린드롬수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while(!s.equals("0")) {
            int len = s.length();
            boolean flag = true;
            for(int i = 0; i < len/2 ; i++) {
                if(s.charAt(i) != s.charAt(len-1-i)) {
                    flag = false;
                    System.out.println("no");
                    break;
                }
            }
            if(flag)
                System.out.println("yes");
            s = br.readLine();
        }
    }
}
