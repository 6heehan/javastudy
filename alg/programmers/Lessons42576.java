package alg.programmers;

import java.util.*;

public class Lessons42576 {
    public static void main(String[] args){

        System.out.println("완주하지 못한 선수 문제");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42576");

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Map<String, Integer> map = new HashMap<>();

        // 참가자를 hashmap 에 담기
        // 처음나온 이름인 경우 1
        // 동일 인물이 있는 경우 원래의 value + 1
        for(String s: participant) {
            map.put(s, map.get(s) == null ? 1 : map.get(s)+1);
        }

        // 완주자를 hashmap 에서 제거
        // 1명만 있는 경우 map 에서 삭제
        // 동일 인물이 있는 경우 value -1 
        for(String s: completion) {
            if(map.get(s) == 1) {
                map.remove(s);
            } else {
                int value = map.get(s);
                map.put(s, value -1);
            }
        }

        // 무조건 1명만 완주하지 못했으므로 answser에 key를 담는다.
        for(String key : map.keySet()) {
            System.out.println(key);
        }

        
    }
}
