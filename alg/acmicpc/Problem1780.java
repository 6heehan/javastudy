package alg.acmicpc;

import java.util.Scanner;

public class Problem1780 {
    // https://www.acmicpc.net/problem/1780
    // 종이의 개수

    static int[][] num;
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static int minusOneCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        num = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        partition(0, 0, n);
        System.out.println(minusOneCnt);
        System.out.println(zeroCnt);
        System.out.println(oneCnt);
        sc.close();
    }

    static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (num[row][col] == 0) {
                zeroCnt++;
            } else if (num[row][col] == 1) {
                oneCnt++;
            } else {
                minusOneCnt++;
            }

            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);

        partition(row + 2 * newSize, col, newSize);
        partition(row + 2 * newSize, col + newSize, newSize);
        partition(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    static boolean check(int row, int col, int size) {
        int color = num[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != num[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
