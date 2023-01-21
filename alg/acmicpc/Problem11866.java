package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11866 {
    // https://www.acmicpc.net/problem/11866
    // 오디푸스 문제0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }
        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                int temp = q.poll();
                q.add(temp);
            }
            if (q.size() != 1) {
                sb.append(q.poll()).append(", ");
            } else {
                sb.append(q.poll()).append(">");
            }
        }

        System.out.println(sb);

    }
}
