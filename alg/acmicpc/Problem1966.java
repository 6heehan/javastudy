package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1966 {
    // https://acmicpc.net/problem/1966
    // 프린터 큐

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t>0) {
            t--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] p = new int[n];

            int[] pCount = new int[10];

            Queue<Data> q = new LinkedList<Data>();
            for(int i = 0; i<n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
                pCount[p[i]]++;
                q.add(new Data(i, p[i]));
            }

            int ans = 0;
            while(true) {
                Data temp = q.poll();
                
                boolean flag = false;
                for(int i=9;i>temp.p;i--) {
                    if(pCount[i] > 0) {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    q.add(temp);
                } else if(temp.index == index) {
                    ans++;
                    break;
                } else {
                    pCount[temp.p]--;
                    ans++;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static class Data {
        int index;
        int p;

        public Data(int index, int p) {
            this.index = index;
            this.p = p;
        }
    }
}
