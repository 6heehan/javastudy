package alg.programmers;

public class Lessons42746 {
    public static void main(String[] args) {
        System.out.println("가장 큰 수");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42746");

        Lessons42746 problem = new Lessons42746();

        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        problem.solution(numbers1);
        problem.solution(numbers2);
    }

    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] changeNumbers = new String[len];
        for(int i=0; i<len; i++) {
            changeNumbers[i] = String.valueOf(numbers[i]);
        }
        String[] caseArray = new String[len*(len-1)];
        int index = 0;
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                //caseArray[index] = 
            }
        }
        return answer;
    }
}
