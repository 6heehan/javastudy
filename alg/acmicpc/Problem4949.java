package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem4949 {
    // https://www.acmicpc.net/problem/4949
    // 균형잡힌 세상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        while (!str.equals(".")) {
            Stack<Integer> s = new Stack<Integer>();
            int len = str.length();
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                char temp = str.charAt(i);
                if (temp == '(') {
                    s.push(1);
                } else if (temp == '[') {
                    s.push(2);
                } else if (temp == ')') {
                    if (s.empty()) {
                        flag = true;
                        break;
                    } else if (s.peek() == 1) {
                        s.pop();
                    }
                } else if (temp == ']') {
                    if (s.empty()) {
                        flag = true;
                        break;
                    } else if (s.peek() == 2) {
                        s.pop();
                    }
                }
            }

            if (flag) {
                sb.append("no").append('\n');
            } else if (s.size() == 0) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
