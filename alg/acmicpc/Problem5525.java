package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5525 {
    // https://www.acmicpc.net/problem/5525
    // IOIOI

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("IO");
        }

        sb.append("I");

        String s = sb.toString();

        int cnt = 0;
        while (true) {
            int index = str.indexOf(s);
            if (index == -1) {
                break;
            }
            cnt++;
            if (m - index >= 2 * n + 1) {
                str = str.substring(index + 2);
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
