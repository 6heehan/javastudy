package alg.programmers;

import java.util.Map;
import java.util.HashMap;

public class Lessons42578 {
    public static void main(String[] args) {
        System.out.println("위장");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42578");

        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        solution(clothes1);
        solution(clothes2);

    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes) {
            //String name = c[0];
            String kind = c[1];
            map.put(kind, map.getOrDefault(kind, 0)+1);
        }
        for(String kind : map.keySet()) {
            answer = answer * (map.get(kind) + 1);
        }
        System.out.println(answer-1);
        return answer-1;
    }
}
