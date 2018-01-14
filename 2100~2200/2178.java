//	BOJ - 2178
//	Algorithm - BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	private static int N,M;
	private static int [][] ad;
	private static boolean [][] visit;
	private static int [] dx = {0,0,1,-1};
	private static int [] dy = {1,-1,0,0};

	private static class Pos{
		int x;
		int y;
		int cnt;
		
		public Pos(int x, int y, int cnt) { // x, y, moving distance
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static Queue<Pos> q = new LinkedList<>();

	public static void BFS(Pos now) {
		
		Pos tmp = now;
		q.offer(now);
		visit[now.x][now.y] = true;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int i=0;i<4;i++) {
				if(now.x+dx[i]>=1 && now.y+dy[i]>=1 && now.x+dx[i]<= N && now.y+dy[i] <= M ){
					if(ad[now.x+dx[i]][now.y+dy[i]]==1 && visit[now.x+dx[i]][now.y+dy[i]] == false) {
						tmp = new Pos(now.x+dx[i],now.y+dy[i],now.cnt+1);
						q.offer(tmp);
						visit[now.x+dx[i]][now.y+dy[i]] = true;
						if(tmp.x == N && tmp.y == M) {
							System.out.println(tmp.cnt);
							break;
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		N = scn.nextInt();
		M = scn.nextInt();
		ad = new int [N+1][M+1];
		visit = new boolean [N+1][M+1];
		for(int i=1;i<N+1;i++) {
			String tmp = scn.next();
			// method(1)
			char [] asChar = tmp.toCharArray();
			int j=1;
			for(char c: asChar) {
				ad[i][j++] = Character.digit(c, 10);
			}
		}
		Pos str = new Pos(1,1,1);
		BFS(str);
	}
}
