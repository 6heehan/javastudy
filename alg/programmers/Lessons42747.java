package alg.programmers;

import java.util.Arrays;

public class Lessons42747 {
    public static void main(String[] args) {

        System.out.println("H-Index");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42747");

        Lessons42747 problem = new Lessons42747();
        int[] citations = {3,0,6,1,5};
        System.out.println(problem.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for(int i = length - 1 ; i > 0; i--) {
            if(length - i >= citations[i]) {
                answer = citations[i];
                break;
            }
        }
        return answer;
    }
}
