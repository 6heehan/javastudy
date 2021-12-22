package alg.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lessons72415 {
    public static void main(String[] args) {

        System.out.println("카드 짝 맞추기");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/72415");
        Lessons72415 problem = new Lessons72415();
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r = 1;
        int c = 0;
        problem.solution2(board, r, c);

    }

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int enterCount = 0;

        for(int i=0; i < 4; i++) {
            for( int j=0; j < 4; j++) {
                if(board[i][j] != 0) enterCount += 1;
            }
        }

        Queue<Position72415> q = new LinkedList<>();
        Position72415 p = new Position72415(c, r, board[r][c], 0, board[r][c] == 0 ? 0 : 1);
        q.offer(p);
        
        while(!q.isEmpty()) {
            Position72415 currentP = q.poll();
            int currentX = currentP.x;
            int currentY = currentP.y;
            int currentV = currentP.value;
            int currentC = currentP.count;
            int findCount = currentP.findCount;

            if(findCount == enterCount && answer > currentC) {
                answer = currentC;
                continue;
            }
            //총 찾은 카드와 뒤집는 개수가 일치하는 경우 최소값 비교

            //카드가 Y축 기준으로 존재
            if(isCardForY(board, currentX, currentY)) {
                for(int i=0; i<4;i++) {
                    //Y축으로 0~3까지 이동하는 모든 경우 확인
                    if(i == currentY) continue;
                    int nextX = currentX;
                    int nextY = i;
                    int nextV = board[nextY][nextX];
                    if(nextV == 0) continue;
                    /*
                    if(currentV == 0) {
                        //아직 찾은 카드가 없는데 카드를 찾았다면 큐에 넣는다.
                        Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount+1);
                        board[nextY][nextX] = 0;
                        q.offer(nextP);
                    } else if(currentV == nextV) {
                        //이미 찾은 카드가 있을 경우 값을 비교해서 넣는다. 이때 찾은 카드가 없으므로 0으로 셋팅
                        Position72415 nextP = new Position72415(nextX, nextY, 0, currentC+1, findCount+1);
                        board[nextY][nextX] = 0;
                        q.offer(nextP);
                    }
                    */
                    if(currentV == nextV) nextV = 0;
                    Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount+1);
                    board[nextY][nextX] = 0;
                    q.offer(nextP);
                    break;
                }
            } else if(currentY == 0) {
                int nextX = currentX;
                int nextY = 3;
                int nextV = board[nextY][nextX];
                Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP);
            } else if(currentY == 3) {
                int nextX = currentX;
                int nextY = 0;
                int nextV = board[nextY][nextX];
                Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP);
            } else{
                int nextX = currentX;
                int nextY = 0;
                int nextV = board[nextY][nextX];
                Position72415 nextP1 = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP1);
                nextY = 3;
                nextV = board[nextY][nextX];
                Position72415 nextP2 = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP2);
            }
            //카드가 없을 경우 Y축 기준 양 끝점으로 이동하는 경우
            
            if(isCardForX(board, currentX, currentY)) {
                for(int i=0; i<4;i++) {
                    if(i == currentX) continue;
                    int nextX = i;
                    int nextY = currentY;
                    int nextV = board[nextY][nextX];
                    //if(currentV != 0 && currentV != nextV) continue;
                    
                    if(currentV == 0) {
                        Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount+1);
                        board[nextY][nextX] = 0;
                        q.offer(nextP);
                    } else if(currentV == nextV) {
                        Position72415 nextP = new Position72415(nextX, nextY, 0, currentC+1, findCount+1);
                        board[nextY][nextX] = 0;
                        q.offer(nextP);
                    }
                }
            } else if(currentX == 0) {
                int nextX = 3;
                int nextY = currentY;
                int nextV = board[nextY][nextX];
                Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP);
            } else if(currentX == 3) {
                int nextX = 0;
                int nextY = currentY;
                int nextV = board[nextY][nextX];
                Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP);
            } else{
                int nextX = 0;
                int nextY = currentY;
                int nextV = board[nextY][nextX];
                Position72415 nextP1 = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP1);
                nextX = 3;
                nextV = board[nextY][nextX];
                Position72415 nextP2 = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                q.offer(nextP2);
            }
            
            
        }
        System.out.println(answer + enterCount);
        return answer + enterCount;
    }

    public boolean isValid(int x, int y) {
        if(x<0 || x>=4) return false;
        if(y<0 || y>=4) return false;
        return true;
    }

    public boolean isCardForY(int[][] board, int x, int y) {
        for(int i=0; i<4;i++) {
            if(i==y) continue;
            if(board[i][x] !=0) return true;
        }
        return false;
    }

    public boolean isCardForX(int[][] board, int x, int y) {
        for(int i=0; i<4;i++) {
            if(i==x) continue;
            if(board[y][i] !=0) return true;
        }
        return false;
    }

    public int solution2(int[][] board, int r, int c) {
        int answer = 0;
        int enterCount = 0;
        int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i < 4; i++) {
            for( int j=0; j < 4; j++) {
                if(board[i][j] != 0) enterCount += 1;
            }
        }
        System.out.println(enterCount);
        Queue<Position72415> q = new LinkedList<>();
        Position72415 p = new Position72415(c, r, board[r][c], 0, board[r][c] == 0 ? 0 : 1);
        q.offer(p);
        
        while(!q.isEmpty()) {
            Position72415 currentP = q.poll();
            int currentX = currentP.x;
            int currentY = currentP.y;
            int currentV = currentP.value;
            int currentC = currentP.count;
            int findCount = currentP.findCount;

            if(findCount == enterCount) {
                if(answer == 0 || answer > currentC)  {
                    answer = currentC;
                    continue;
                }
            }
            //총 찾은 카드와 뒤집는 개수가 일치하는 경우 최소값 비교

            //네 방향으로 다 이동이 가능
            //컨트롤을 누르고 이동 시 해당 방향에서 가장 가까운 카드로 이동 , 만약 없다면 해당 방향의 끝으로 이동
            
            boolean[] moveDirection = new boolean[4];
            for(int i=0; i<move.length; i++) {
                //move[i][0] y
                //move[i][1] x
                int dist = 0;
                for(int j=1; j<4; j++) {
                    int nextX = currentX + move[i][1] * j;
                    int nextY = currentY + move[i][0] * j;
                    if(!isValid(nextX, nextY)) continue;
                    dist = j;
                    if(!moveDirection[i]) {
                        
                        int nextV = board[nextY][nextX];
                        if(nextV != 0) {
                            Position72415 nextP = null;
                            moveDirection[i] = true;
                            if(currentV == 0) {
                              
                                nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount+1);
                                q.offer(nextP);
                            } else if(currentV == nextV) {
                              
                                nextP = new Position72415(nextX, nextY, 0, currentC+1, findCount+1);
                                q.offer(nextP);
                            } 
                        }
                    }
                }
                if(!moveDirection[i]) {
                    int nextX = currentX + move[i][1] * dist;
                    int nextY = currentY + move[i][0] * dist;
                    int nextV = currentV;
                    Position72415 nextP = new Position72415(nextX, nextY, nextV, currentC+1, findCount);
                    q.offer(nextP);
                }
            }

        }
        System.out.println(answer + enterCount);
        return answer + enterCount;
    }
}

class Position72415 {
    int x;
    int y;
    int value;
    int count;
    int findCount;

    public Position72415 (int x, int y, int value, int count, int findCount) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.count = count;
        this.findCount = findCount;
    }
}