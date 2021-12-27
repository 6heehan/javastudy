package alg.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lessons42583 {
    public static void main(String[] args) {
        System.out.println("다리를 지나는 트럭");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42583");

        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7,4,5,6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        solution2(bridge_length1, weight1, truck_weights1);
        solution2(bridge_length2, weight2, truck_weights2);
        solution2(bridge_length3, weight3, truck_weights3);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Data42583> q = new LinkedList<>();
        Stack<Data42583> s = new Stack<>();
        for(int t : truck_weights) {
            Data42583 tempD = new Data42583(bridge_length, t);
            q.offer(tempD);
            //s.add(tempD);
        }

        for(int i=truck_weights.length; i>0;i--) {
            Data42583 tempD = new Data42583(bridge_length, truck_weights[i-1]);
            s.add(tempD);
        }

        while(!s.isEmpty()) {
            answer++;
            Data42583 tempD = s.pop();
            int totalWeight = tempD.truckWeight;
            while(weight >= totalWeight) {
                
            }

        }
        System.out.println(answer);
        return answer;
    }

    public static int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bq = new LinkedList<>();
        Queue<Integer> tq = new LinkedList<>();

        for(int i=0;i<bridge_length;i++) {
            bq.offer(0);
        }

        for(int i : truck_weights) {
            tq.offer(i);
        }

        int time = 0;
        int totalWeight = 0;
        while(!bq.isEmpty()) {
            totalWeight -= bq.peek();
            bq.poll();

            if(tq.isEmpty()) {
                time += bridge_length;
                break;
            } else {
                if((totalWeight + tq.peek()) <= weight) {
                    bq.offer(tq.peek());
                    totalWeight += tq.peek();
                    tq.poll();
                } else {
                    bq.offer(0);
                }
            }
            time++;
        }
        answer = time;
        System.out.println(answer);
        return answer;
    }

}

class Data42583{
    int remainLen;
    int truckWeight;

    public Data42583(int remainLen, int truckWeight) {
        this.remainLen = remainLen;
        this.truckWeight = truckWeight;
    }
}