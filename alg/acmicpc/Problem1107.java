package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1107 {
    // https://www.acmicpc.net/problem/1107
    // 리모컨

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int target = scan.nextInt();
        int m = scan.nextInt();

        boolean[] broken = new boolean[10];
        for (int i = 0; i < m; i++) {
            int n = scan.nextInt();
            broken[n] = true;
        }

        int result = Math.abs(target - 100); // 초기값 설정
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if (broken[str.charAt(j) - '0']) { // 고장난 버튼을 눌러야 하면
                    isBreak = true;
                    break; // 더 이상 탐색하지 않고 빠져나온다.
                }
            }
            if (!isBreak) { // i를 누를때 고장난 버튼을 누르지 않는다면
                int min = Math.abs(target - i) + len; // i를 누른 후(len) target까지 이동하는 횟수(target - i)
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
        scan.close();
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int len = temp.length();
        int n = Integer.parseInt(temp);

        int[] channel = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            channel[i] = n % 10;
            n = n / 10;
        }

        int m = Integer.parseInt(br.readLine());

        boolean[] isBroken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int brokenNumber = Integer.parseInt(st.nextToken());
                isBroken[brokenNumber] = true;
            }
        }

        n = Integer.parseInt(temp);
        if (n == 100) {
            System.out.println(0);
            return;
        }

        StringBuilder bigSb = new StringBuilder();
        StringBuilder smallSb = new StringBuilder();

        bigSb.append(0);
        smallSb.append(0);

        // 첫번째는 아래와 같이
        // 다음번째 숫자들은 small big 이 반대로
        for (int i = channel[0]; i < 10; i++) {
            if (!isBroken[i]) {
                bigSb.append(i);
                break;
            }
        }

        for (int i = channel[0]; i > 0; i--) {
            if (!isBroken[i]) {
                smallSb.append(i);
                break;
            }
        }

        for (int i = 1; i < len; i++) {
            int c = channel[i];
            for (int j = 9; j >= 0; j--) {
                if (c == 0 && !isBroken[j]) {
                    smallSb.append(j);
                    break;
                }
                if (!isBroken[j] && c >= j) {
                    smallSb.append(j);
                    break;
                }
            }

            for (int j = 0; j < 10; j++) {
                if (!isBroken[j] && c <= j) {
                    bigSb.append(j);
                    break;
                }
            }
        }

        int big = Integer.parseInt(bigSb.toString());
        int small = Integer.parseInt(smallSb.toString());

        int res = Math.min(Math.abs(big - n), Math.abs(n - small));
        res = Math.min(res + len, Math.abs(n - 100));
        System.out.println(res);
    }
}
