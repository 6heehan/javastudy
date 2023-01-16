package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920 {
    // https://www.acmicpc.net/problem/1920
    // 수 찾기

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int N = Integer.parseInt(br.readLine());
        // int[] A = new int[N];
        // // ArrayList a = new ArrayList<Integer>();
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int index = 0;
        // while(st.hasMoreTokens()) {
        //     A[index] = Integer.parseInt(st.nextToken());
        //     // a.add(Integer.parseInt(st.nextToken()));
        //     index++;
        // }

        // int M = Integer.parseInt(br.readLine());
        // int[] num = new int[M];
        // st = new StringTokenizer(br.readLine());
        // index = 0;
        // StringBuilder sb = new StringBuilder();
        // while(st.hasMoreTokens()) {
        //     num[index] = Integer.parseInt(st.nextToken());
        //     // if(a.contains(num[index])) {
        //     //     sb.append("1\n");
        //     // } else {
        //     //     sb.append("0\n");
        //     // }
        //     boolean flag = false;
        //     for(int i=0; i<N; i++) {
        //         if(num[index] == A[i])
        //             flag = true;
        //     }

        //     if(flag)
        //         sb.append("1\n");
        //     else 
        //         sb.append("0\n");
        //     index++;
        // }
        // System.out.println(sb);

        sovle();
    }

    static void sovle() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String temp = br.readLine();
        String[] tempA = temp.split(" ");
        int index = 0;
        while(index != N) {
            A[index] = Integer.parseInt(tempA[index]);
            index++;
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        
        temp = br.readLine();
        String [] tempNum = temp.split(" ");
        index = 0;
        StringBuilder sb = new StringBuilder();
        while(index != M) {
            if(Arrays.binarySearch(A, Integer.parseInt(tempNum[index])) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
            
            index++;
        }
        System.out.println(sb);
    }
}
