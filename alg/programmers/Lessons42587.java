package alg.programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Lessons42587 {
    public static void main(String[] args) {
        System.out.println("프린터");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42587");

        int[] priorities1 = {2,1,3,2};
        int location1 = 2;

        int[] priorities2 = {1,1,9,1,1,1};
        int location2 = 0;

        solution(priorities1, location1);
        solution(priorities2, location2);

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int count = 0;
        Queue<Data42587> q = new LinkedList<>();
        Iterator<Data42587> iter = null;

        for(int i=0; i< priorities.length; i++) {
            Data42587 newD = new Data42587(priorities[i], i);
            q.offer(newD);
        }

        while(!q.isEmpty()) {
            Data42587 tempD = q.poll();
            iter = q.iterator();
            boolean isNotMax = false;
            while(iter.hasNext()) {
                Data42587 iterD = iter.next();
                if(tempD.value < iterD.value) {
                    isNotMax = true;
                    break;
                }
            }
            if(isNotMax) {
                q.offer(tempD);
                continue;
            }
            count++;
            if(tempD.index == location) answer = count;
        }
        System.out.println(answer);
        return answer;
    }
}

class Data42587 {
    int value;
    int index;

    public Data42587(int value, int index) {
        this.value = value;
        this.index = index;
    }
}