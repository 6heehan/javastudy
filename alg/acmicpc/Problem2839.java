package alg.acmicpc;

import java.util.Scanner;

public class Problem2839 {
    // https://www.acmicpc.net/problem/2839
    // 설탕 배달

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int res = 1001;

        boolean flag = false;
        int five = N / 5;
        int temp = 0;
        for (int i = five; i > 0; i--) {
            if ((N - 5 * i) % 3 == 0) {
                flag = true;
                temp = i;
                break;
            }
        }
        // int temp5 = (N-5*temp) % 5;
        if (flag) {
            res = temp + (N - 5 * temp) / 3;
        }

        int temp3 = N % 3;
        if (temp3 == 0) {
            res = Math.min(N / 3, res);
        } else if (!flag) {
            res = -1;
        }

        System.out.println(res);
        sc.close();
    }
}
