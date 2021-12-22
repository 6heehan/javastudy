package alg.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.crypto.Data;

public class Lessons42586 {
    public static void main(String[] args) {

        System.out.println("기능개발");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42586");

        int [] progresses1 = {93,30,55};
        int [] speeds1 = {1,30,5};

        int[] progresses2 = {95,90,99,99,80,99};
        int[] speeds2 = {1,1,1,1,1,1};

        solution(progresses1, speeds1);
        solution(progresses2, speeds2);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        //int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        Queue<Data42586> q = new LinkedList<>();
        Iterator<Data42586> iter = null;
        for(int i=0; i < progresses.length; i++) {
            Data42586 newData = new Data42586(progresses[i], speeds[i], false);
            q.offer(newData);
        }

        while(!q.isEmpty()) {
            for(int i=0; i< q.size(); i++) {
                Data42586 tempD = q.poll();
                if(tempD.isEnd) {
                    q.offer(tempD);
                    continue;
                }
                
                int nextP = tempD.progress + tempD.speed;
                boolean currentCheck = tempD.isEnd;
                if(nextP >= 100) {
                    nextP = 100;
                    currentCheck = true;
                }

                Data42586 nextD = new Data42586(nextP, tempD.speed, currentCheck);
                q.offer(nextD);
            }

            int count = 0;
            iter = q.iterator();
            Data42586 firstD = q.peek();
            if(firstD.isEnd) {
                while(iter.hasNext()) {
                    Data42586 iterD = iter.next();
                    if(iterD.isEnd) count++;
                    else break;
                }
            }
            for(int i=0;i<count;i++) {
                q.poll();
            }

            if(count!=0) {
                answer.add(count);
            }

        }
        for(int a : answer) {
            System.out.println(a);
        }
        System.out.println("===");
        Integer[] answerArrI = new Integer[answer.size()];
        answer.toArray(answerArrI);
        int[] answerArr = Arrays.stream(answerArrI).mapToInt(Integer::intValue).toArray();
        return answerArr;
    }
}

class Data42586 {
    int progress;
    int speed;
    boolean isEnd;

    public Data42586(int progress, int speed, boolean isEnd) {
        this.progress = progress;
        this.speed = speed;
        this.isEnd = isEnd;
    }
}
