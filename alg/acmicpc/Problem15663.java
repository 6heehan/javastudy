package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem15663 {
    // https://www.acmicpc.net/problem/15663
    // N과 M (9)

    static int n, m;
    static int arr[];
    static int num[];
    static int numIdx[];

    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    static HashMap<String, Integer> map = new HashMap<>();
    static Queue<String> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        num = new int[n];
        numIdx = new int[n + 1];

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
        /*
         * for (String key : map.keySet()) {
         * System.out.println(key);
         * }
         */
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }

    static void dfs(int depth) {

        if (depth == m) {
            StringBuilder tempSb = new StringBuilder();
            for (int val : arr) {
                tempSb.append(val).append(" ");
            }
            // tempSb.append("\n");
            if (map.getOrDefault(tempSb.toString(), -1) == -1) {
                map.put(tempSb.toString(), cnt++);
                q.offer(tempSb.toString());
            }
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

        int idxLength = numIdx[n];
        for (int i = 0; i < n; i++) {
            boolean isDuplicated = false;
            for (int j = 0; j < idxLength; j++) {
                if (i == numIdx[j]) {
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) {
                arr[depth] = num[i];
                numIdx[idxLength] = i;
                numIdx[n] += 1;
                dfs(depth + 1);
                numIdx[n] -= 1;
            }
        }
    }
}
