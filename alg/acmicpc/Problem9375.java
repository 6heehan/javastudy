package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem9375 {
    // https://www.acmicpc.net/problem/9375
    // 패션왕 신해빈

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            StringTokenizer st = null;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }
            if (map.size() == 1) {
                int res = 0;
                for (String k : map.keySet()) {
                    res = map.get(k);
                }
                sb.append(res).append("\n");
            } else {
                int res = 1;
                int[] cnt = new int[map.size()];
                int idx = 0;
                for (String k : map.keySet()) {
                    cnt[idx] = map.get(k);
                    idx++;
                }

                for (int k = 0; k < idx; k++) {
                    res = res * (cnt[k] + 1);
                }

                sb.append(res - 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
