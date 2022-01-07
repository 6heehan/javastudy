package alg.programmers;

import java.util.Arrays;

public class Lessons42862 {
    public static void main(String[] args) {

        System.out.println("체육복");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42862");
        Lessons42862 problem = new Lessons42862();
        int n1 = 5;
        int[] lost1 = {2,4};
        int[] reserve1 = {1,3,5};

        int n2 = 5;
        int[] lost2 = {2,4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        int n4 = 30;
        int[] lost4 = {1,2,7,9,10,11,12,14,15,16,18,20,21,24,25,27};
        int[] reserve4 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,20,22,23,24,25,26,27,28};

        int n5 = 3;
        int[] lost5 = {1,2};
        int[] reserve5 = {2,3};

        System.out.println(problem.solution(n1, lost1, reserve1));
        System.out.println(problem.solution(n2, lost2, reserve2));
        System.out.println(problem.solution(n3, lost3, reserve3));
        System.out.println(problem.solution(n4, lost4, reserve4));
        System.out.println(problem.solution(n5, lost5, reserve5));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -2;
                    answer++;
                }
            }
        }
        for(int i=0; i<lost.length; i++) {
            int temp = lost[i];
            if(lost[i] == -2 ) continue;
            for(int j=0; j<reserve.length; j++) {
                if(reserve[j] == -1) continue;
                if(temp -1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                } else if(temp + 1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
