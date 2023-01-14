package alg.acmicpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2869 {
    // https://www.acmicpc.net/problem/2869
    // 달팽이는 올라가고 싶다

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int res = (V-B) / (A-B);

        if((V-B) % (A-B) !=0)
            res++;
        
        System.out.println(res);
        
        
    }
    
}
