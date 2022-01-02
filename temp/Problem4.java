package temp;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {

    public static void main(String[] args) {
        int[] price = {0,2,1,1,2};
        int n = price.length;
        Solution4 problem4 = new Solution4();
        problem4.solution(n, price);
    }
}

class Solution4 {
    public int solution(int n, int[] price) {
        int answer = 0;
        Queue<Stone> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(price[i] == 0) {
                Stone s = new Stone(i+1, 1, 0);
                q.offer(s);
                break;
            }
        }
        while(!q.isEmpty()) {
            Stone currentStone = q.poll();
            int currentDay = currentStone.day;
            int currentCount = currentStone.count;
            int currentGain = currentStone.gain;
            
            if(currentDay == n) {
                if(answer < currentGain)
                    answer = currentGain;
                continue;
            }

            int todayPrice = price[currentDay];

            // gain이 있다면 구입( n개 판매 )
            if(currentGain >= todayPrice) {
                for(int i=0; i<=currentCount; i++) {
                    Stone buyStone = new Stone(currentDay+1, currentCount+1, currentGain-todayPrice);
                    buyStone.setCount(buyStone.getCount() - i);
                    buyStone.setGain(buyStone.getGain() + i * todayPrice);
                    q.offer(buyStone);
                }
            }
            // 구입 x ( n개 판매 )
            for(int i=0; i<=currentCount; i++) {
                Stone noBuyStone = new Stone(currentDay+1, currentCount, currentGain);
                noBuyStone.setCount(noBuyStone.getCount() - i);
                noBuyStone.setGain(noBuyStone.getGain() + i * todayPrice);
                q.offer(noBuyStone);
            }
            
        }
        System.out.println(answer);
        return answer;
    }

    class Stone {
        int day;
        int count;
        int gain;
    
        public Stone(int day, int count, int gain) {
            this.day = day;
            this.count = count;
            this.gain = gain;
        }
    
        public void setCount(int count) {
            this.count = count;
        }
    
        public void setGain(int gain) {
            this.gain = gain;
        }
    
        public int getCount() {
            return this.count;
        }
    
        public int getGain() {
            return this.gain;
        }
    }
}

