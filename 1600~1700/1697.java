//	BOJ - 1697
//	Algorithm - BFS

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int a;	//	subin's position
	static int b;	//	sister's position
	static boolean [] visit = new boolean [200002];
	static class Pos{
		int x;
		int cnt;
		
		public Pos(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	static Queue <Pos> q = new <Pos> LinkedList(); // 시행을 큐에 저장해라!!!

	public static int BFS(Pos now) {
		Pos tmp = now;
		q.offer(now);
		visit[now.x] = true;
		while(true) {
			now = q.poll();
			if(now.x == b) {
				return now.cnt;
			}
			//System.out.print(now.x + " ");
			if(now.x-1>=0  && !visit[now.x-1]) {
				tmp = new Pos(now.x-1,now.cnt+1);
				q.offer(tmp);
				visit[now.x-1] = true;
				/*
				if(tmp.x == b) {
					return tmp.cnt;
				}
				*/
			}
			if(b>now.x && !visit[now.x+1]) {
				tmp = new Pos(now.x+1,now.cnt+1);
				q.offer(tmp);
				visit[now.x+1] = true;
				/*
				if(tmp.x == b) {
					return tmp.cnt;
				}
				*/
			}
			if( b > now.x && !visit[now.x*2]) {
				tmp = new Pos(now.x*2,now.cnt+1);
				q.offer(tmp);
				visit[now.x*2] = true;
				/*
				if(tmp.x == b) {
					return tmp.cnt;
				}
				*/
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		a= scn.nextInt();
		b= scn.nextInt();
		for( int i=0;i<200002;i++) {
			visit[i] = false;
		}
		if(a!=b) System.out.print(BFS(new Pos(a,0)));
		else System.out.print(0);
	}
}
