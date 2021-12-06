// 11-2_6heehan
// 한 준 희

package assignment.week3;

import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        int x,y;
        int[][] coordinate = new int[10][2];
        int inputCount = 0;
        int minDistanceIndex = 0;
        double minDistance = Double.MAX_VALUE;

        boolean isDuplicated = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("나의 x좌표값을 입력해주세요 : ");
        x = sc.nextInt();
        System.out.println("나의 y좌표값을 입력해주세요 : ");
        y = sc.nextInt();

        while(inputCount != 10) {
            System.out.println(inputCount+1 + "/10 번째 입력");
            System.out.println("x좌표값을 입력해주세요 : ");
            int tempX = sc.nextInt();
            System.out.println("y좌표값을 입력해주세요 : ");
            int tempY = sc.nextInt();

            for(int i = 0 ; i < inputCount; i++) {
                if(tempX == coordinate[i][0] && tempY == coordinate[i][1]) {
                    isDuplicated = true;
                }
            }

            if(!isDuplicated) {
                coordinate[inputCount][0] = tempX;
                coordinate[inputCount][1] = tempY;
                double tempDistance = Math.sqrt((tempX - x)*(tempX-x) + (tempY - y)*(tempY - y));
                if(minDistance > tempDistance) {
                    minDistance = tempDistance;
                    minDistanceIndex = inputCount;
                }
                inputCount++;
            } else {
                System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요. ");
                isDuplicated = false;
            }

        }

        for(int i=0; i<coordinate.length; i++) {
            System.out.println("(" + coordinate[i][0] +"," + coordinate[i][1] +") => " + Math.sqrt((coordinate[i][0] - x)*(coordinate[i][0]-x) + (coordinate[i][1] - y)*(coordinate[i][1] - y)));
        }
        System.out.println("나와 가장 가까운 좌표값은 ("+coordinate[minDistanceIndex][0]+","+coordinate[minDistanceIndex][1]+") 입니다.");
        System.out.println("제일 가까운 좌표: ");
        System.out.println("(" + coordinate[minDistanceIndex][0] + "," +coordinate[minDistanceIndex][1] + ") => " + minDistance);
        System.out.println("같은 거리가 있는 경우 먼저 입력된 좌표를 기준입니다.");

        sc.close();
    }
}
