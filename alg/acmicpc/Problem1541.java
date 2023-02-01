package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1541 {
    // https://www.acmicpc.net/problem/1541
    // 잃어버린 괄호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // System.out.println(str.length());
        int len = str.length();
        int start = 0;
        int end = 0;
        int sum = 0;
        boolean minusFlag = false;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '+') {
                int temp = Integer.parseInt(str.substring(start, end + 1));
                if (minusFlag) {
                    sum -= temp;
                } else {
                    sum += temp;
                }
                start = i + 1;
            } else if (str.charAt(i) == '-') {
                int temp = Integer.parseInt(str.substring(start, end + 1));
                if (minusFlag) {
                    sum -= temp;
                } else {
                    sum += temp;
                }
                minusFlag = true;
                start = i + 1;
            } else {
                end = i;
                if (i == len - 1) {
                    int temp = Integer.parseInt(str.substring(start, end + 1));
                    if (minusFlag) {
                        sum -= temp;
                    } else {
                        sum += temp;
                    }
                }
            }
        }

        System.out.println(sum);
        /*
         * String[] s = str.split("[^0-9]");
         * for (String string : s) {
         * System.out.println(Integer.parseInt(string));
         * }
         */
    }
}
