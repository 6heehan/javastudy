package alg.programmers;

public class Lessons43162 {

    public static void main(String[] args) {
        System.out.println("네트워크");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/43162");

        Lessons43162 problem = new Lessons43162();
        int n1 = 3;
        int[][] computers1 = {{1,1,0},{1,1,0},{0,0,1}};
        int n2 = 3;
        int[][] computers2 = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(problem.solution(n1, computers1));
        System.out.println(problem.solution(n2, computers2));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i=0;i < n; i++) {
            if(visit[i] == false) {
                answer++;
                visit[i] = true;
                dfs(n, i, computers, visit);
            }
        }
        return answer;
    }

    public static void dfs(int n, int index, int[][] computers, boolean[] visit) {
        if(checkAll(visit)) return;
        for(int i=0; i < n; i++) {
            if(i==index) continue;
            if(computers[i][index] == 1 && visit[i] == false) {
                visit[i] = true;
                dfs(n, i, computers, visit);
            }
        }
    }

    public static boolean checkAll(boolean[] visit) {
        for(int i = 0; i < visit.length; i++) {
            if(visit[i] == false) {
                return false;
            }
        }
        return true;
    }


}
