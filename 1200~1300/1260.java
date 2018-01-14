//	BOJ - 1260
//	Algorithm - DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	private static int N,M,V;
	private static int [][] ad;
	private static boolean [] visit;
	private static Queue <Integer> q = new <Integer> LinkedList();		// declare Queue in Java

	public static void DFS(int str) {
		visit[str] = true;
		System.out.print(str+" ");
		
		for(int i=0;i<N+1;i++) {
			if(ad[str][i] == 1 && visit[i] == false) {
				DFS(i);
			}
		}
	}

	public static void BFS(int str) {
		
		//Queue <Integer> q = new <Integer> LinkedList();		// declare Queue in Java
		q.offer(str);
		visit[str] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int i=0;i<=N;i++) {
				if(ad[temp][i] == 1 && visit[i] == false) {
					q.offer(i);								// push num
					visit[i] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input_x,input_y;
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		V = scn.nextInt();
		ad = new int [N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			for(int j=0;j<N+1;j++) {
				ad[i][j] = 0;
			}
		}
		
		for(int i=0;i<M;i++) {
			input_x = scn.nextInt();
			input_y = scn.nextInt();
			ad[input_x][input_y] = ad[input_y][input_x] = 1;
		}
		for(int i=0;i<=N;i++) {
			ad[i][i] = 1;
		}
		DFS(V);
		System.out.println();
		for(int i=0;i<N+1;i++) {
			visit[i]=false;
		}
		BFS(V);
	}
}
