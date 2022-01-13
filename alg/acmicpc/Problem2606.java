package alg.acmicpc;

import java.util.Scanner;

public class Problem2606 {
    public static void main(String[] args) {
        System.out.println("바이러스");
        System.out.println("https://www.acmicpc.net/problem/2606");
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int nodeNum = sc.nextInt();
        //int[] virus = new int[n];
        Node[] node = new Node[nodeNum];
        for(int i=0; i<nodeNum; i++) {
            int tempS = sc.nextInt();
            int tempE = sc.nextInt();
            node[i] = new Node(tempS, tempE);
        }
        sc.close();
    }
}

class Node {
    int startNode;
    int endNode;

    public Node(int s, int e) {
        this.startNode = s;
        this.endNode = e;
    }
}
