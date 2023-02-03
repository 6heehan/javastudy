package alg.acmicpc;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem18870 {
    // https://www.acmicpc.net/problem/18870
    // 좌표 압축

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[n];
        int[] copyNum = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            copyNum[i] = num[i];
        }

        Arrays.sort(copyNum);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            map.put(copyNum[i], idx);
            if (i != n - 1 && copyNum[i] != copyNum[i + 1]) {
                idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            int temp = num[i];
            sb.append(map.get(temp)).append(" ");
        }

        System.out.println(sb);
        sc.close();
    }
}
