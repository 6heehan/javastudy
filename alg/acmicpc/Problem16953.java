package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16953 {

    // https://www.acmicpc.net/problem/16953
    // A → B

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new LinkedList<>();

        q.offer(new long[] { a, 1 });

        long res = -1;
        while (!q.isEmpty()) {
            long[] val = q.poll();
            long num = val[0];
            long cnt = val[1];

            if (num == b) {
                res = cnt;
                break;
            }

            if (num < b) {
                q.offer(new long[] { num * 2, cnt + 1 });
                q.offer(new long[] { num * 10 + 1, cnt + 1 });
            }
        }

        System.out.println(res);
    }
}
