package alg.acmicpc;

import java.io.*;

public class Problem15998 {

    public static void main(String[] args) {

        System.out.println("카카오머니");
        System.out.println("https://www.acmicpc.net/problem/15998");
        int M = 5;
        int[][] money = {{1500, 1500}, {-17000, 4500}, {1200,5700}, {-5600, 100}, {-200, 9900}};

        int M1 = 2;
        int[][] money1 = {{-5,0}, {-6,1}};

        
        solution(M, money);
        solution(M1,money1);
        
    }

    public static void solution(int M, int[][] money) {
        int answer = Integer.MAX_VALUE;

        for(int i =0 ; i < money.length; i++) {
            if(money[i][0] < 0) {
                if(i==0) {
                    answer = money[i][1] - money[i][0];
                    continue;
                }

                int tempM = money[i][1] - money[i][0] - money[i-1][1];
                if(tempM == 0) continue;
                if(tempM > answer) tempM = -1;
                answer = Math.min(answer, tempM);
            }
        }
        System.out.println(answer);

    }


    public void presentation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String input = br.readLine();
            int M = Integer.valueOf(input);
            int[][] money = new int[M][2];
            for(int i = 0 ; i < M ; i ++) {
                String moneyInput = br.readLine();
                String[] tempInput = moneyInput.split(" ");
                money[i][0] = Integer.valueOf(tempInput[0]);
                money[i][1] = Integer.valueOf(tempInput[1]);
                
            }
            int answer = Integer.MAX_VALUE;
            for(int i =0 ; i < money.length; i++) {
                if(money[i][0] < 0) {
                    if(i==0) {
                        answer = money[i][1] - money[i][0];
                        continue;
                    }

                    int tempM = money[i][1] - money[i][0] - money[i-1][1];
                    if(tempM == 0) continue;
                    if(tempM > answer) tempM = -1;
                    answer = Math.min(answer, tempM);
                }
            }
            System.out.println(answer);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }    
}
