package alg.programmers;

import java.util.Arrays;

import temp.Problem1;

public class Lessons43164 {
    public static void main(String[] args) {
        System.out.println("여행경로");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/43164");

        Lessons43164 problem = new Lessons43164();
        //problem.solution(tickets);

        //[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
        //[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

        String[][] tickets1 = {{"ICN","JFK"} ,{"HND","IAD"} ,{"JFK","HND"}};
        String[][] ticktes2 = {{"ICN","SFO"} ,{"ICN","ATL"} ,{"SFO","ATL"} ,{"ATL","ICN"} ,{"ATL","SFO"}};

        problem.solution(tickets1);
    }
    //Arrays.sort(changeNumbers, (o1, o2) -> (o2+o1).compareTo(o1+o2));
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        String start = "ICN";

        Arrays.sort(tickets, (o1, o2) -> (o1[1]).compareTo(o2[1]));
        // 도착지 기준으로 오름차순 정렬
        
        return answer;
    }

    // 1. 인덱스 배열을 저장해서 마지막에 조립한다.
    // 2. 한 경로를 갈 때 마다 배열을 업데이트 한다.
}
