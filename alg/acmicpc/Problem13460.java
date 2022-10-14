package alg.acmicpc;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int rX;
    int rY;
    int bX;
    int bY;
    int cnt;

    Pair(int rX, int rY, int bX, int bY, int cnt) {
        this.rX = rX;
        this.rY = rY;
        this.bX = bX;
        this.bY = bY;
        this.cnt = cnt;
    }
}

public class Problem13460 {
    // https://www.acmicpc.net/problem/13460
    // 구슬 탈출2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair red = null;
        Pair blue = null;
        int hX = 0;
        int hY = 0;

        
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] map = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];
        
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0 ; i < N ; i++) {
            String temp = sc.next();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'R') {
                    red = new Pair(j,i,0,0,0);
                } else if (map[i][j] == 'B') {
                    blue = new Pair(j,i,0,0,0);
                } else if (map[i][j] == 'O') {
                    hX = j;
                    hY = i;
                }
            }
        }
        
        q.add(new Pair(red.rX, red.rY, blue.bX, blue.bY, 1));
        while(!q.isEmpty()) {
            Pair cP = q.poll();
            int rX = cP.rX;
            int rY = cP.rY;
            int bX = cP.bX;
            int bY = cP.bY;
            int cCnt = cP.cnt;

            if(cCnt > 10) {
                System.out.println("-1");
                break;
            }

            visited[rX][rY][bX][bY] = true;

            for(int i=0; i<4; i++) {
                int newRX = rX;
                int newRY = rY;
                int newBX = bX;
                int newBY = bY;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                while(map[newRY + dy[i]][newRX + dx[i]] != '#') {
                    newRY += dy[i];
                    newRX += dx[i];

                    if(newRY == hY && newRX == hX) {
                        isRedHole = true;
                        break;
                    }
                }

                while(map[newBY + dy[i]][newBX + dx[i]] != '#') {
                    newBY += dy[i];
                    newBX += dx[i];

                    if(newBY == hY && newBX == hX) {
                        isBlueHole = true;
                        break;
                    }
                }

                if(isBlueHole) 
                    continue;
                
                if(isRedHole && !isBlueHole) {
                    System.out.println(cCnt);
                    break;
                }

                if(newRX == newBX && newRY == newBY) {
                    if( i == 0 ) {
                        if(rX > bX) newRX -= dx[i];
                        else newBX -= dx[i];
                    } else if( i == 1 ) {
                        if(rY > bY) newBY -= dy[i];
                        else newRY -= dy[i];
                    } else if ( i == 2 ) {
                        if(rX > bX) newBX -= dx[i];
                        else newRX -= dx[i];
                    } else {
                        if(rY > bY) newRY -= dy[i];
                        else newBY -= dy[i];
                    }
                }

                if(!visited[newRX][newRY][newBX][newBY]) {
                    visited[newRX][newRY][newBX][newBY] = true;
                    q.add(new Pair(newRX, newRY, newBX, newBY, cCnt+1));
                }
            }

               
        }
        sc.close();
    }
}
