package alg.programmers;

import java.util.Arrays;

public class Lessons43164 {

    String[] answer = {};

    public static void main(String[] args) {
        System.out.println("여행경로");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/43164");

        Lessons43164 problem = new Lessons43164();

        String[][] tickets1 = {{"ICN","JFK"} ,{"HND","IAD"} ,{"JFK","HND"}};
        String[][] tickets2 = {{"ICN","SFO"} ,{"ICN","ATL"} ,{"SFO","ATL"} ,{"ATL","ICN"} ,{"ATL","SFO"}};

        problem.solution(tickets1);
        problem.solution(tickets2);
    }

    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        String start = "ICN";

        Arrays.sort(tickets, (o1, o2) -> (o2[1]).compareTo(o1[1]));
        // 도착지 기준으로 오름차순 정렬
        // 가장 빠른 알파벳이 마지막에 찾아짐.

        int[] visitIndex = new int[tickets.length];
        for(int i=0; i<visitIndex.length; i++) {
            visitIndex[i] = -1;
        }
        for(int i=0; i< tickets.length; i++) {
            if(start.equals(tickets[i][0])) {
                visitIndex[0] = i;
                dfs(tickets, 1, visitIndex);
                visitIndex[0] = -1;
            }
        }
        return answer;
    }

    public void dfs(String[][] tickets, int cnt, int[] visitIndex) {
        if(tickets.length == cnt) {
            for(int i=0; i<visitIndex.length; i++) {
                answer[i] = tickets[visitIndex[i]][0];
                if(i == visitIndex.length - 1) {
                    answer[i+1] = tickets[visitIndex[i]][1];
                }
            }
            return;
        }

        String start = tickets[visitIndex[cnt-1]][1];
        for(int i=0; i<tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !isVisit(visitIndex, i)) {
                visitIndex[cnt] = i;
                dfs(tickets, cnt+1, visitIndex);
                visitIndex[cnt] = -1;
            }
        }
    }

    public boolean isVisit(int[] visitIndex, int index) {
        for(int i=0; i<visitIndex.length; i++) {
            if(index == visitIndex[i]) return true;
        }
        return false;
    }
    
    // 1. 인덱스 배열을 저장해서 마지막에 조립한다.
    // 2. 한 경로를 갈 때 마다 배열을 업데이트 한다.
}
