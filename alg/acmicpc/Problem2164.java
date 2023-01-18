package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2164 {
    // https://www.acmicpc.net/problem/2164
    // 카드 2

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<N; i++) {
            q.add(i+1);
        }

        while(q.size()!=1) {
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.poll());
    }
}
