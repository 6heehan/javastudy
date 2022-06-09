package alg.acmicpc;

import java.util.Scanner;

public class Problem3052 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/3052
        // 나머지
        
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        int[] res = new int[10];
        int count = 0;
        for(int i=0; i<10; i++) {
            num[i] = sc.nextInt();
            res[i] = num[i] % 42;
            for(int j=0; j<i; j++) {
                if(res[j] == res[i]) {
                    res[j] = -1;
                    count++;
                }
            }
        }
        System.out.println(10-count);
        sc.close();
    }
}
