package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2805 {
    // https://www.acmicpc.net/problem/2805
    // 나무 자르기

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for(int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] > max)
                max = tree[i];
        }

        /* int h = 0;
        while(true) {
            int sum = 0;
            if(h==70)
                System.out.println("h==70");
            for(int i=0;i<N;i++) {
                if(tree[i] > h)
                    sum += tree[i] - h;
            }
            if(sum <= M-1)
                break;
            h++;
        }
        System.out.println(h-1);
 */
        while(min < max) {
            int mid = (min + max) /2;
            long sum = 0;
            for(int treeH : tree) {
                if(treeH - mid > 0)
                    sum += (treeH - mid);
            }

            if(sum < M)
                max = mid;
            else
                min = mid+1;
        }

        System.out.println(min -1);
    }
}
