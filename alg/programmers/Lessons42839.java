package alg.programmers;

import java.util.HashSet;

public class Lessons42839 {
    public static void main(String[] args) {
        System.out.println("소수 찾기");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42839");

        Lessons42839 problem = new Lessons42839();
        System.out.println(problem.solution("17"));
        System.out.println(problem.solution("011"));
    }

    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        while(set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) answer++;
            if(a%2 !=0 && isPrime(a)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isPrime(int n) {
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2) {
            if(n%1==1) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for(int i=0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, n), set);
        }
    }
    
}
