package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1978 {

    // https://acmicpc.net/problem/1978
    // 소수 찾기
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            res = res + find(Integer.parseInt(st.nextToken()));
        }
        System.out.println(res);
    }
    
    static int find(int num) {
        if(num < 2)
            return 0;
        
        for(int i=2; i<=Math.sqrt(num);i++) {
            if(num%i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
