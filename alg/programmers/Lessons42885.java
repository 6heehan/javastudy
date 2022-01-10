package alg.programmers;

import java.util.*;

public class Lessons42885 {
    public static void main(String[] args) {
        System.out.println("구명보트");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42885");

        Lessons42885 problem = new Lessons42885();
        int[] people1 = {70,50,80,50};
        int[] people2 = {70,80,50};
        int limit = 100;

        int[] people3 = {160,150,140,60,50,40};
        int limit2 = 200;

        int[] people4 = {100,500,500,900,950};
        int limit3 = 1000;
        // System.out.println(problem.solution(people1, limit));
        // System.out.println(problem.solution(people2, limit));
        // System.out.println(problem.solution(people3, limit2));
        System.out.println(problem.solution(people4, limit3));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        // for(int i : people) {
        //     System.out.println(i);
        // }
        int index = people.length - 1;
        for(int i=0; i<people.length; i++) {
            int weight = people[i];
            if(weight == 0) continue;
            for(int j=people.length-1 ; j>=0 ; j--) {
                if(people[j] != 0 && weight + people[j] <= limit) {
                    people[j] = 0;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}
