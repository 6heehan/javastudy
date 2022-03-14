package alg.acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem1181 {
    public static void main(String[] args) {
        // https://www.acmicpc.net/problem/1181
        // 단어 정렬

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] words = new String[N];

        sc.nextLine(); // 개행 버림

        for(int i = 0; i < N ; i++) {
            words[i] = sc.nextLine();
        }
        
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        for(int i=0; i<N; i++) {
            if(i==0) {
                System.out.println(words[i]);
            } else {
                if(!words[i].equals(words[i-1])) {
                    System.out.println(words[i]);
                }
            }
        }
        sc.close();
    }
}
