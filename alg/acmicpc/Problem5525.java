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

        char[] c = br.readLine().toCharArray();

        int cnt = 0;
        int res = 0;

        for (int i = 1; i < m - 1; i++) {
            if (c[i - 1] == 'I' && c[i] == 'O' && c[i + 1] == 'I') {
                cnt++;
                if (cnt == n) {
                    cnt--;
                    res++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }

        System.out.println(res);
    }
}
