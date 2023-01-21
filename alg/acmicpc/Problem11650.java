package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem11650 {
    // https://www.acmicpc.net/problem/11650
    // 좌표 정렬하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Cord[] c = new Cord[n];

        for (int i = 0; i < n; i++) {
            c[i] = new Cord(br.readLine());
        }

        Arrays.sort(c, new Comparator<Cord>() {
            @Override
            public int compare(Cord o1, Cord o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });

        for (Cord cord : c) {
            System.out.println(cord.toString());
        }
    }

    static class Cord {
        int x;
        int y;

        public Cord() {

        }

        public Cord(String c) {
            String[] temp = c.split(" ");

            if (temp.length != 2)
                new IOException();

            this.x = Integer.parseInt(temp[0]);
            this.y = Integer.parseInt(temp[1]);
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }
}
