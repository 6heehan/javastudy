package temp;

public class Problem2 {

    boolean[][] isVisited;
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    // static int[][] board1 = {{1,2},{3,4}};
    // static int[][] board1 = {{1,2,3},{4,5,6},{7,8,9}};
    // static int[][] board1 = {{1,4,7},{2,5,8},{3,6,9}};
    static int[][] board1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    // static int[][] board1 = {{1,4,7,},{2,5,8},{3,6,9}};
    int maxValue = 0;
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        // int[][] board1 = {{1,2},{3,4}};
        // int[][] board2 = {{1,2,3,},{4,5,6},{7,8,9}};

        problem2.solution(board1);
        //problem2.solution(board2);

        // Solution solution = new Solution();
        // System.out.println(solution.solution(board1));

    }

    public void solution(int[][] board) {
        //int answer = 0;
        int N = board.length;
        // 세로
        int M = board[0].length;
        // 가로
        isVisited = new boolean[N][M];
        //isVisited[0][0] = true;
        dfs(0,0,0);
        System.out.println(maxValue);
    }

    public void dfs(int x, int y, int sum) {
        isVisited[y][x] = true;
        int currentSum = sum + board1[y][x];
        if(x == isVisited[0].length-1 && y == isVisited.length-1) {
            if(maxValue < currentSum) maxValue = currentSum;
        }
        for(int i = 0; i < 4; i++) {
            int nextX = x + move[i][1];
            int nextY = y + move[i][0];
            if(isValid(nextX, nextY) && !isVisited[nextY][nextX]) {
                dfs(nextX, nextY, currentSum);
            }
        }
        isVisited[y][x] = false;
    }

    public boolean isValid(int x, int y) {
        if(x < 0 || x >= isVisited[0].length) return false;
        if(y < 0 || y >= isVisited.length) return false;
        return true;
    }
}



class SolutionKakaoBank2 {

    
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    // static int[][] board1 = {{1,2},{3,4}};
    // static int[][] board1 = {{1,2,3,},{4,5,6},{7,8,9}};
    int maxValue = 0;

    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        // 세로
        int M = board[0].length;
        // 가로
        boolean[][] isVisited = new boolean[N][M];
        //방문여부 기록
        dfs(0,0,0, board, isVisited);
        //재귀호출
        
        answer = maxValue;
        return answer;
    }

    public void dfs(int x, int y, int sum, int[][] board, boolean[][] isVisited) {
        isVisited[y][x] = true;
        int currentSum = sum + board[y][x];
        if(maxValue < currentSum) maxValue = currentSum;
        if(x == isVisited[0].length-1 && y == isVisited.length-1) return;
        for(int i = 0; i < 4; i++) {
            int nextX = x + move[i][1];
            int nextY = y + move[i][0];
            if(isValid(nextX, nextY, isVisited) && !isVisited[nextY][nextX]) {
                dfs(nextX, nextY, currentSum, board, isVisited);
            }
        }
    }

    public boolean isValid(int x, int y, boolean[][] isVisited) {
        if(x < 0 || x >= isVisited[0].length) return false;
        if(y < 0 || y >= isVisited.length) return false;
        return true;
    }
}