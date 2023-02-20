package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem9019 {
    // https://www.acmicpc.net/problem/9019
    // DSLR

    static Queue<Data> q;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            isVisited = new boolean[10000];
            doFunction("", a);

            while (!q.isEmpty()) {
                Data d = q.poll();
                String currentC = d.command;
                int currentV = d.value;

                if (currentV == b) {
                    sb.append(currentC).append("\n");
                    break;
                }

                doFunction(currentC, currentV);
            }
        }

        System.out.println(sb);
    }

    static void doFunction(String command, int num) {
        int dV = D(num);
        int sV = S(num);
        int lV = L(num);
        int rV = R(num);
        if (!isVisited[dV]) {
            q.offer(new Data(command + "D", dV));
            isVisited[dV] = true;
        }
        if (!isVisited[sV]) {
            q.offer(new Data(command + "S", sV));
            isVisited[sV] = true;
        }

        if (!isVisited[lV]) {
            q.offer(new Data(command + "L", lV));
            isVisited[lV] = true;
        }

        if (!isVisited[rV]) {
            q.offer(new Data(command + "R", rV));
            isVisited[rV] = true;
        }

    }

    static int D(int num) {
        int temp = num * 2;
        if (temp > 9999) {
            temp = temp % 10000;
        }
        return temp;
    }

    static int S(int num) {
        if (num == 0) {
            return 9999;
        } else {
            return num - 1;
        }
    }

    static int L(int num) {
        int n = num;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;

        if (n / 1000 > 0) {
            d1 = n / 1000;
            n = n % 1000;
        }

        if (n / 100 > 0) {
            d2 = n / 100;
            n = n % 100;
        }

        if (n / 10 > 0) {
            d3 = n / 10;
            n = n % 10;
        }

        d4 = n;

        n = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
        return n;
    }

    static int R(int num) {
        int n = num;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        int d4 = 0;

        if (n / 1000 > 0) {
            d1 = n / 1000;
            n = n % 1000;
        }

        if (n / 100 > 0) {
            d2 = n / 100;
            n = n % 100;
        }

        if (n / 10 > 0) {
            d3 = n / 10;
            n = n % 10;
        }

        d4 = n;

        n = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
        return n;
    }

    static class Data {
        String command;
        int value;

        public Data() {

        }

        public Data(String s, int i) {
            command = s;
            value = i;
        }
    }
}
