package alg.programmers;

import java.util.*;

public class Lessons42885 {
    public static void main(String[] args) {
        System.out.println("구명보트");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42885");

        Lessons42885 problem = new Lessons42885();

        // System.out.println(problem.solution(new int[]{70,50,80,50}, 100));
        // System.out.println(problem.solution(new int[]{70,80,50} , 100));
        // System.out.println(problem.solution(new int[]{160,150,140,60,50,40}, 200));
        // System.out.println(problem.solution(new int[]{100,500,500,900,950}, 1000));
        // System.out.println(problem.solution(new int[]{10,10,10,10,10}, 50));
        // System.out.println(problem.solution(new int[]{50}, 50));
        // System.out.println(problem.solution(new int[]{20,50,50,80}, 100));
        // System.out.println(problem.solution(new int[]{70,50,80,50}, 100));
        // System.out.println(problem.solution(new int[]{50,30,20,70,10}, 100));
        System.out.println(problem.solution(new int[]{10,20,30,40,50,60,70,80,90}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = people.length - 1;
        for(int i=0; i < index+1; i++) {
            int weight = people[i];
            if(weight == 0) continue;
            for(int j=index ; j>=0 ; j--) {
                if(i == index) {
                    break;
                } else if(weight + people[j] <= limit) {
                    people[j] = 0;
                    index--;
                    break;
                } else {
                    answer++;
                    people[j] = 0;
                    index--;
                }
            }
            answer++;
        }
        return answer;
    }
}
