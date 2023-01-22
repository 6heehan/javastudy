package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11723 {
    // https://acmicpc.net/problem/11723
    // 집합

    static boolean[] check = new boolean[21];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens())
                num = Integer.parseInt(st.nextToken());

            switch (command) {
                case "add":
                    add(num);
                    break;
                case "remove":
                    remove(num);
                    break;
                case "check":
                    check(num);
                    break;
                case "toggle":
                    toggle(num);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        System.out.println(sb);
    }

    static void add(int n) {
        if (!check[n])
            check[n] = true;
    }

    static void remove(int n) {
        if (check[n])
            check[n] = false;
    }

    static void check(int n) {
        if (check[n]) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }

    static void toggle(int n) {
        if (check[n])
            check[n] = false;
        else
            check[n] = true;
    }

    static void all() {
        for (int i = 1; i <= 20; i++) {
            check[i] = true;
        }
    }

    static void empty() {
        for (int i = 1; i <= 20; i++) {
            check[i] = false;
        }
    }
}
