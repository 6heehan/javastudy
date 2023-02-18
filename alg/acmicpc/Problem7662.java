package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem7662 {
    // https://www.acmicpc.net/problem/7662
    // 이중 우선순위 큐

    static PriorityQueue<Integer> oneQ;
    static PriorityQueue<Integer> twoQ;

    static boolean isOne = true;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> q = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    q.put(n, q.getOrDefault(n, 0) + 1);
                } else {
                    if (q.size() == 0)
                        continue;

                    int num = n == 1 ? q.lastKey() : q.firstKey();
                    if (q.put(num, q.get(num) - 1) == 1)
                        q.remove(num);
                }
            }

            System.out.println(q.size() == 0 ? "EMPTY" : q.lastKey() + " " + q.firstKey());
        }
    }

    static void solve() throws IOException {
        // 시간 초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            oneQ = new PriorityQueue<>(Collections.reverseOrder());
            twoQ = new PriorityQueue<>(Collections.reverseOrder());
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    insert(num);
                } else {
                    delete(num);
                }
            }

            printAnswer();
        }
        System.out.println(sb);
    }

    static void insert(int num) {
        if (isOne) {
            oneQ.offer(num);
        } else {
            twoQ.offer(num);
        }
    }

    static void delete(int num) {
        if (oneQ.isEmpty() && twoQ.isEmpty()) {
            return;
        }

        if (isOne) {
            int size = oneQ.size();
            int index = num > 0 ? size - 1 : 0;
            while (!oneQ.isEmpty()) {
                int temp = oneQ.poll();
                if (index == oneQ.size())
                    continue;
                twoQ.offer(temp);
            }
            isOne = !isOne;
        } else {
            int size = twoQ.size();
            int index = num > 0 ? size - 1 : 0;
            while (!twoQ.isEmpty()) {
                int temp = twoQ.poll();
                if (index == twoQ.size())
                    continue;
                oneQ.offer(temp);
            }
            isOne = !isOne;
        }
    }

    static void printAnswer() {
        if (oneQ.isEmpty() && twoQ.isEmpty()) {
            sb.append("EMPTY\n");
        }

        else if (isOne) {
            int size = oneQ.size();
            int index1 = size - 1;
            int index2 = 0;
            while (!oneQ.isEmpty()) {
                int temp = oneQ.poll();
                if (index1 != oneQ.size() && index2 != oneQ.size()) {
                    continue;
                }
                sb.append(temp + " ");
            }
            sb.append("\n");
        } else {
            int size = twoQ.size();
            int index1 = size - 1;
            int index2 = 0;
            while (!twoQ.isEmpty()) {
                int temp = twoQ.poll();
                if (index1 != twoQ.size() && index2 != twoQ.size()) {
                    continue;
                }
                sb.append(temp + " ");
            }
            sb.append("\n");
        }
    }
}
