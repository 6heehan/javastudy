package alg.programmers;

import java.util.*;

public class Lessons42577 {
    

    public static void main(String[] args) {
        System.out.println("전화번호 목록");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42577");

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        
        solution(phone_book1);
        solution(phone_book2);
        solution(phone_book3);

        
    }

    public static void solution(String[] phone_book) {
        boolean answer = true;
        Map<Integer, String> map = new HashMap<>();
        int index = 0;
        Arrays.sort(phone_book);
        for(String s: phone_book) {
            System.out.println(s);
        }
        for(String s: phone_book) {
            map.put(index, s);
            index++;
        }
        
        for(String number: map.values()) {
            for(int i = 0; i < index; i++) {
                if(map.get(i).equals(number)) continue;
                if(number.startsWith(map.get(i))){
                    answer = false;
                } 
            }

        }
        
        /*
        int indexM = 0;
        for(String number: map.values()) {
            if(number.equals(map.get(indexM))) {
                continue;
            } else if(number.startsWith(map.get(indexM))) {
                answer = false;
            } else {
                indexM++;
            }
        }
        */

        System.out.println(answer);
    }
}
