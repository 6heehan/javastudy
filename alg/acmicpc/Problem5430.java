package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Problem5430 {
    // https://www.acmicpc.net/problem/5430
    // AC

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String temp = br.readLine();

            Deque<Integer> q = new LinkedList<>();

            if (n > 0) {
                temp = temp.substring(1, temp.length() - 1);
                int[] num = new int[n];
                int index = 0;
                for (String s : temp.split(",")) {
                    num[index] = Integer.parseInt(s);
                    q.offer(num[index]);
                    index++;
                }
            }

            int commandLen = p.length();
            boolean isFront = true;
            boolean isError = false;
            for (int j = 0; j < commandLen; j++) {
                char command = p.charAt(j);
                if (command == 'R') {
                    isFront = !isFront;
                } else if (q.size() != 0) {
                    if (isFront) {
                        q.removeFirst();
                    } else {
                        q.removeLast();
                    }
                } else {
                    isError = true;
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                int len = q.size();
                for (int j = 0; j < len; j++) {
                    if (isFront) {
                        sb.append(q.pollFirst());
                    } else {
                        sb.append(q.pollLast());
                    }

                    if (j != len - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }

        }
        System.out.println(sb);
    }
}
