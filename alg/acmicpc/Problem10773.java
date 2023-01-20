package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10773 {
    // https://www.acmicpc.net/problem/10773
    // 제로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                s.pop();
            } else {
                s.push(temp);
            }
        }

        int res = 0;
        while (!s.empty()) {
            res += s.pop();
        }

        System.out.println(res);

    }
}
