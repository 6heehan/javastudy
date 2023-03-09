package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem15663 {
    // https://www.acmicpc.net/problem/15663
    // N과 M (9)

    static int n, m;
    static int arr[];
    static int num[];

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    static HashMap<String, Integer> map = new HashMap<>();

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
        // System.out.print(sb);
        printRes();
    }

    static void printRes() {
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }

    static void dfs(int depth) {

        if (depth == m) {
            StringBuilder tempSb = new StringBuilder();
            for (int val : arr) {
                tempSb.append(val).append(" ");
            }
            // tempSb.append("\n");
            map.put(tempSb.toString(), cnt++);
            return;
        }

        /*
         * for (int i = 0; i < n; i++) {
         * boolean isDuplicated = false;
         * for (int j = 0; j < depth; j++) {
         * if (num[i] == arr[j]) {
         * isDuplicated = true;
         * break;
         * }
         * }
         * if (!isDuplicated) {
         * arr[depth] = num[i];
         * dfs(depth + 1);
         * }
         * }
         */

        for (int i = 0; i < n; i++) {
        }
    }
}
