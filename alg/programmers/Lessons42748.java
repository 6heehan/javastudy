package alg.programmers;

import java.util.Arrays;

public class Lessons42748 {
    public static void main(String[] args) {
        System.out.println("K번째수");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42748");

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        Lessons42748 problem = new Lessons42748();
        problem.solution(array, commands);
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i<commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        for(int a : answer) {
            System.out.println(a);
        }
        return answer;
    }

}
