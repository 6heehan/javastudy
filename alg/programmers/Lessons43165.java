package alg.programmers;

import java.util.*;

public class Lessons43165 {

    public static void main(String[] args) {
        System.out.println("타겟 넘버");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/43165");

        int[] numbers = {1,1,1,1,1};
        int target = 3;
        solution(numbers, target);
        solutionRefactoring(numbers, target);
    }

    public static void solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<N> q = new LinkedList<>();
        
        q.offer(new N(numbers[0], numbers[0], 1));
        q.offer(new N(numbers[0], numbers[0] * -1 , 1));
        while(!q.isEmpty()) {
            N currentN = q.poll();
            
            if((currentN.sum == target) && (currentN.index == numbers.length)){
                answer++;
                continue;
            }
            if(currentN.index == numbers.length) continue;
            q.offer(new N(numbers[currentN.index], currentN.sum + numbers[currentN.index], currentN.index+1));
            q.offer(new N(numbers[currentN.index], currentN.sum - numbers[currentN.index], currentN.index+1));
        }
        System.out.println(answer);
    }

    public static void solutionRefactoring(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, 0, target);
        
        System.out.println(answer);
        
    }

    public static int dfs(int[] numbers, int n, int sum, int target) {
        if(n== numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, n+1, sum + numbers[n], target) + dfs(numbers, n+1, sum-numbers[n] , target);
    }
}
class N {
    int num;
    int sum;
    int index;

    public N(int num, int sum, int index) {
        this.num = num;
        this.sum = sum;
        this.index = index;
    }
}
