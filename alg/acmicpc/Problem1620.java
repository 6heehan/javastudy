package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1620 {
    // https://acmicpc.net/problem/1620
    // 나는야 포켓몬마스터 이다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> mapI = new HashMap<>();
        HashMap<String, Integer> mapS = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            mapI.put(i + 1, name);
            mapS.put(name, i + 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            char tempC = temp.charAt(0);
            if (tempC < 65) {
                int tempIndex = Integer.parseInt(temp);
                sb.append(mapI.get(tempIndex)).append("\n");
            } else {
                sb.append(mapS.get(temp)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
