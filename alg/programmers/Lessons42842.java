package alg.programmers;

public class Lessons42842 {
    public static void main(String[] args) {
        System.out.println("카펫");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42842");

        Lessons42842 problem = new Lessons42842();
        // problem.solution(10, 2);
        // problem.solution(8, 1);
        // problem.solution(24, 24);
        problem.solution(14, 4);
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 가로 >= 세로
        // 가로 * 세로 = brown + yellow
        // 가로 - 2 * 세로 - 2 = yellow 
        int area = brown + yellow;
        for(int i = 3; i <= area; i++) {
            int row = i;
            int col = area / row;
            if(area % row != 0)
                continue;
            if(row > col) 
                continue;

            if((row-2) * (col -2) == yellow) {
                answer[0] = col;
                answer[1] = row;
            }
        }
        return answer;
    }
}
