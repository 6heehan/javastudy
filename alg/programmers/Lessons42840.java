package alg.programmers;
import java.util.*;

public class Lessons42840 {
    public static void main(String[] args) {
        System.out.println("모의고사");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42840");
        Lessons42840 problem = new Lessons42840();
        int [] answers1 = {1,2,3,4,5};
        int [] answers2 = {1,3,2,4,2};
        problem.solution(answers1);
        problem.solution(answers2);
    }

    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] count = new int[3];
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == student1[i%5]) count[0]++;
            if(answers[i] == student2[i%8]) count[1]++;
            if(answers[i] == student3[i%10]) count[2]++;
        }
        int max = 0;
        for(int i=0; i<3; i++) {
            if(max < count[i]) max = count[i];
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(max == count[i])  list.add(i+1);
        }
        //Arrays.stream(answerArrI).mapToInt(Integer::intValue).toArray();
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        for(int a: answer) {
            System.out.println(a);
        }
        return answer;
    }
}
