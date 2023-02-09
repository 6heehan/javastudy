package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem11286 {
    // https://www.acmicpc.net/problem/11286
    // 절대값 힙

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());

            if (c == 0) {
                if (plusQ.size() == 0 && minusQ.size() == 0) {
                    sb.append("0\n");
                } else if (plusQ.size() == 0) {
                    sb.append(minusQ.poll()).append("\n");
                } else if (minusQ.size() == 0) {
                    sb.append(plusQ.poll()).append("\n");
                } else {
                    if (minusQ.peek() * -1 <= plusQ.peek())
                        sb.append(minusQ.poll()).append("\n");
                    else
                        sb.append(plusQ.poll()).append("\n");
                }
            } else if (c > 0) {
                plusQ.offer(c);
            } else {
                minusQ.offer(c);
            }
        }

        System.out.println(sb);
    }
}