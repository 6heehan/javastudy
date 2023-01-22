package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem1764 {
    // https://acmicpc.net/problem/1764
    // 듣보잡

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> h = new HashSet<>();
        for (int i = 0; i < n; i++) {
            h.add(br.readLine());
        }

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String tempName = br.readLine();
            if (h.contains(tempName)) {
                res.add(tempName);
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }
}
