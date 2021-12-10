package alg.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1931 {
    public static void main(String[] args) {
        System.out.println("회의실 배정");
        System.out.println("https://www.acmicpc.net/problem/1931");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //int[][] I = new int[N][2];
        Num1931[] num = new Num1931[N];
        /*
        for(int i=0;i<N;i++) {
            I[i][0] = sc.nextInt();
            I[i][1] = sc.nextInt();
        }

        for(int i=0;i<N;i++) {
            for(int j=i;j<N;j++) {
                if(I[i][1] > I[j][1]) {
                    int tempStart = I[i][0];
                    int tempEnd = I[i][1];

                    I[i][0] = I[j][0];
                    I[i][1] = I[j][1];

                    I[j][0] = tempStart;
                    I[j][1] = tempEnd;
                }
            }
        }
        int nextTime = 0;
        int answer = 0;
        for(int i=0;i<N;i++) {
            if(nextTime <= I[i][0]) {
                nextTime = I[i][1];
                answer += 1;
            }
        }

        System.out.println(answer);
        sc.close();
        */
        for(int i=0;i<N;i++) {
            int tempS = sc.nextInt();
            int tempE = sc.nextInt();
            num[i] = new Num1931(tempS, tempE);
        }
        Arrays.sort(num);
        int nextTime = 0;
        int answer = 0;
        for(int i=0;i<N;i++) {
            if(nextTime <= num[i].startTime) {
                nextTime = num[i].endTime;
                answer++;
            }
        }
        System.out.println(answer);
        sc.close();
    }
}

class Num1931 implements Comparable<Num1931> {

    int startTime;
    int endTime;

    public Num1931(int s, int e) {
        this.startTime = s;
        this.endTime = e;
    }
    @Override
    public int compareTo(Num1931 o) {
        if (endTime > o.endTime) return 1;
        // 오름차순
        else if(endTime < o.endTime) return -1;
        // 내림차순
        else if(startTime > o.startTime) return 1;
        else if(startTime < o.startTime) return -1;
        // endTime 이 같을 때 startTime 기준으로 오름,내림 차순 지정
        
        else return 0;
        //같을때
        
        //return endTime - o.endTime;
    }
    
}
