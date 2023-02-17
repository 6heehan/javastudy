package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16928 {
    // https://www.acmicpc.net/problem/16928
    // 뱀과 사다리 게임

    static int count[] = new int[101];
    static int ladderAndSnake[] = new int[101];
    static boolean isVisited[] = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladderAndSnake[a] = b;
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        count[1] = 0;
        isVisited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) {
                System.out.println(count[cur]);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int x = cur + i;
                if (100 < x)
                    continue;
                if (isVisited[x])
                    continue;
                isVisited[x] = true;

                if (ladderAndSnake[x] != 0) {
                    if (!isVisited[ladderAndSnake[x]]) {
                        q.offer(ladderAndSnake[x]);
                        isVisited[ladderAndSnake[x]] = true;
                        count[ladderAndSnake[x]] = count[cur] + 1;
                    }
                } else {
                    q.offer(x);
                    count[x] = count[cur] + 1;
                }
            }
        }
    }
}
