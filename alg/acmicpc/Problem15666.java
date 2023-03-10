package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem15666 {
    // https://www.acmicpc.net/problem/15666
    // N과 M (12)

    static int n, m;
    static int[] arr;
    static int[] num;

    static Queue<String> q = new LinkedList<>();
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        dfs(0);

        printRes();
    }

    static void printRes() {
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
            String temp = tempSb.toString();
            if (map.getOrDefault(temp, -1) == -1) {
                map.put(temp, 0);
                q.offer(temp);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth == 0 || arr[depth - 1] <= num[i]) {
                arr[depth] = num[i];
                dfs(depth + 1);
            }
        }
    }
}
