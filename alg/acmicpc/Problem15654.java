package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15654 {
    // https://www.acmicpc.net/problem/15654
    // N과 M(5)

    static int n, m;
    static int[] arr;
    static int[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int val : arr) {
                // System.out.print(val + " ");
                sb.append(val).append(" ");
            }
            // System.out.println();
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean isDuplicated = false;
            for (int j = 0; j < depth; j++) {
                if (arr[j] == num[i]) {
                    isDuplicated = true;
                    break;
                }
            }

            if (!isDuplicated) {
                arr[depth] = num[i];
                dfs(depth + 1);
            }
        }
    }
}
