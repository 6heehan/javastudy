package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem10866 {
    // https://www.acmicpc.net/problem/10866
    // 덱

    static LinkedList<Integer> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case ("push_front"):
                    push_front(num);
                    break;
                case ("push_back"):
                    push_back(num);
                    break;
                case ("pop_front"):
                    pop_front();
                    break;
                case ("pop_back"):
                    pop_back();
                    break;
                case ("size"):
                    size();
                    break;
                case ("empty"):
                    empty();
                    break;
                case ("front"):
                    front();
                    break;
                case ("back"):
                    back();
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push_front(int num) {
        list.addFirst(num);
    }

    static void push_back(int num) {
        list.addLast(num);
    }

    static void pop_front() {
        if (list.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(list.pollFirst()).append("\n");
        }
    }

    static void pop_back() {
        if (list.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(list.pollLast()).append("\n");
        }
    }

    static void size() {
        sb.append(list.size()).append("\n");
    }

    static void empty() {
        if (list.isEmpty()) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    static void front() {
        if (list.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(list.peekFirst()).append("\n");
            ;
        }
    }

    static void back() {
        if (list.isEmpty()) {
            sb.append("-1\n");
        } else {
            sb.append(list.peekLast()).append("\n");
            ;
        }
    }
}
