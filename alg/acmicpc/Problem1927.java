package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1927 {
    // https://www.acmicpc.net/problem/1927
    // 최소 힙

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (q.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.add(num);
            }
        }
    }
}
