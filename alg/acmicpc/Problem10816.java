package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10816 {
    // https://www.acmicpc.net/problem/10816
    // 숫자 카드2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] cntP = new int[10000001];
        int[] cntM = new int[10000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tempNum = Integer.parseInt(st.nextToken());
            num[i] = tempNum;
            if (tempNum < 0) {
                cntM[tempNum * -1]++;
            } else {
                cntP[tempNum]++;
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int tempNum = Integer.parseInt(st.nextToken());
            if (tempNum < 0) {
                sb.append(cntM[tempNum * -1]);
            } else {
                sb.append(cntP[tempNum]);
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
