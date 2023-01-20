package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7568 {
    // https://acmicpc.net/problem/7568
    // 덩치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Body[] b = new Body[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            b[i] = new Body(w, h);
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (b[i].compare(b[j]))
                    count++;
            }
            sb.append(count + 1).append(" ");
        }

        System.out.println(sb);
    }

    static class Body {
        int w;
        int h;

        public Body() {

        }

        public Body(int weight, int height) {
            this.w = weight;
            this.h = height;
        }

        public boolean compare(Body b) {
            if (this.w < b.w && this.h < b.h)
                return true;
            else
                return false;
        }
    }
}
