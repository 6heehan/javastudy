package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem11279 {
    // https://www.acmicpc.net/problem/11279
    // 최대 힙

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (q.isEmpty()) {
                    // System.out.println("0");
                    sb.append("0\n");
                } else {
                    // System.out.println(q.poll());
                    sb.append(q.poll()).append("\n");
                }
            } else {
                q.add(num);
            }
        }

        System.out.println(sb);
    }
}
