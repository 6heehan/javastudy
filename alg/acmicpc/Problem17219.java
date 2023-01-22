package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem17219 {
    // https://www.acmicpc.net/problem/17219
    // 비밀번호 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> password = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pass = st.nextToken();

            password.put(site, pass);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            sb.append(password.get(site)).append("\n");
        }

        System.out.println(sb);
    }

}
