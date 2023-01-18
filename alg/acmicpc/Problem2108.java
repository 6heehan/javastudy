package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2108 {
    // https://acmicpc.net/problem/2108
    // 통계학

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        int sum = 0;
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }

        Arrays.sort(num);
/*
        int cnt = 0;
        int cnt_max = 0;
        int cnt_res = 0;
        int cnt_max_pre = 0;
        int cnt_res_pre = 0;


        for(int i=N-1; i>=0; i--) {
            if(i!=0 && num[i] == num[i-1])
                cnt++;
            else {
                if(cnt_max == 0) {
                    cnt_max = cnt;
                    cnt_res = num[i];
                    cnt = 0;
                } else if(cnt_max <= cnt) {
                    cnt_max_pre = cnt_max;
                    cnt_res_pre = cnt_res;
                    cnt_max = cnt;
                    cnt_res = num[i];
                    cnt = 0;
                }
            }
        }
        double res_temp = Math.round(sum/N * 10) /10.0;

        sb.append(res_temp < 0 ? res_temp -1 : res_temp).append('\n');
        sb.append(num[(N-1)/2]).append('\n');
        if(cnt_max == 0) {
            sb.append(num[0]).append('\n');
        } else if(cnt_max == cnt_res_pre) {
            sb.append(cnt_res_pre).append('\n');
        } else {
            sb.append(cnt_res).append('\n');
        }
        sb.append(MAX-MIN).append('\n');
 */

        boolean flag = false;
        int mode_max = 0;
        int mode = 100000;

        for(int i=0; i < N; i++) {
            int jump = 0;
            int count = 1;
            int i_value = num[i];

            for(int j=i+1; j<N; j++) {
                if(i_value != num[j])
                    break;
                count++;
                jump++;
            }

            if(count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            } else if(count==mode_max && flag == true) {
                mode = i_value;
                flag = false;
            }

            i += jump;
        }

        //double res_temp = Math.round(sum/N * 10) /10.0;
        //sb.append(res_temp < 0 ? res_temp -1 : res_temp).append('\n');
        sb.append((int)Math.round((double)sum/N)).append('\n');
        sb.append(num[N/2]).append('\n');
        sb.append(mode).append('\n');
        sb.append(num[N-1] - num[0]).append('\n');
        System.out.println(sb);
    }
}
