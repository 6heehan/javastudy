package alg.programmers;

import java.util.*;

public class Lessons42746 {
    public static void main(String[] args) {
        System.out.println("가장 큰 수");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42746");

        Lessons42746 problem = new Lessons42746();

        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        int[] numbers3 = {0,0,0};
        System.out.println(problem.solution(numbers1));
        System.out.println(problem.solution(numbers2));
        System.out.println(problem.solution(numbers3));
    }

    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] changeNumbers = new String[len];
        for(int i=0; i<len; i++) {
            changeNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(changeNumbers, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        for(String s: changeNumbers) {
            //System.out.println(s);
            answer = answer + s;
        }
        if(answer.startsWith("0")) answer = "0";
        return answer;
    }
}
