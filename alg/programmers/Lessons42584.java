package alg.programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Lessons42584 {
    public static void main(String[] args) {

        System.out.println("주식가격");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42584");

        int[] prices = {1,2,3,2,3};
        // solution(prices);
        solution2(prices);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++) {
            int count = 0;
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i] <= prices[j]) count++;
            }
            answer[i] = count;
        }

        for(int a: answer) {
            System.out.println(a);
        }
        return answer;
    }

    public static int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q= new LinkedList<>();
        Iterator<Integer> iter = null;
        int index = 0;
        for(int p : prices) {
            q.offer(p);
        }
        while(!q.isEmpty()) {
            int count = 0;
            int currentP = q.poll();
            iter = q.iterator();
            while(iter.hasNext()) {
                //if(iter.next() >= currentP) count++;
                count++;
                if(iter.next() < currentP) break;
            }
            answer[index++] = count;
        }

        for(int a: answer) {
            System.out.println(a);
        }
        return answer;
    }

}
