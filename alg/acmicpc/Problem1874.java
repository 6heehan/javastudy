package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1874 {
    // https://www.acmicpc.net/problem/1874
    // 스택 수열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<Integer>();
        int[] arr = new int[n];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            num[i] = i;
        }

        int index = 0;
        int index_num = 1;

        while (index_num <= n) {

            if (index_num == arr[index]) {
                sb.append("+\n").append("-\n");
                index_num++;
                index++;

                int temp_size = s.size();
                for (int i = temp_size - 1; i >= 0; i--) {
                    if ((int) s.get(i) == arr[index]) {
                        sb.append("-\n");
                        s.pop();
                        index++;
                    } else {
                        break;
                    }
                }

            } else {
                sb.append("+\n");
                s.push(index_num);
                index_num++;
            }
        }

        if (s.size() != 0)
            System.out.println("NO");
        else
            System.out.println(sb);
    }
}
