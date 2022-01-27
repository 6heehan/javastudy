package alg.programmers;

import java.util.Stack;

public class Lessons42883 {
    public static void main(String[] args) {
        System.out.println("큰 수 만들기");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42883");

        Lessons42883 problem = new Lessons42883();

        System.out.println(problem.solution("1924", 2));
        System.out.println(problem.solution("1231234", 3));
        System.out.println(problem.solution("4177252841", 4));
        System.out.println(problem.solution2("4177252841", 4));

    }

    public String solution(String number, int k) {
        // String answer = "";
        // int len = answer.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j=index; j<=k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }

    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for(int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
