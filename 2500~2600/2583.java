
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 2583
//	Algorithm - DFS BFS

public class Main {
	
	static int m,n; // m: 세로 n: 가로
	static int k;
	static long l;
	static Queue<Area> q = new LinkedList<Area>();
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	
	private static class Pos{
		int x;
		int y;
		
		public Pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static class Area{
		int x;
		int y;
		int type;	// 0:not visited 1:filled 2:visited
		
		public Area(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	private static class Map{
		Area [][] map;
		int area_cnt=0;
		
		public Map(int m,int n) {
			this.map = new Area [m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = new Area(i,j,0);
				}	
			}
		}
		
		public void square(Pos f,Pos s) {
			for(int i=f.x;i<s.x;i++) {
				for(int j=f.y;j<s.y;j++) {
					map[m-j-1][i].type = 1;
				}
			}
		}
		
		public int find_space() {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j].type==0) {
						return(BFS(map[i][j]));
					}
				}
			}
			return 0;
		}
		
		public void print() {
			System.out.println();
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map[i][j].type+ " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		public int BFS(Area now) {
			area_cnt=0;
			Area tmp = now;
			q.offer(now);
			this.map[tmp.x][tmp.y].type = 2;
			area_cnt++;
			while(!q.isEmpty()) {
				now = q.poll();
				for(int i=0;i<4;i++) {
					if(now.x+dx[i]>=0 && now.y+dy[i]>=0 && now.x+dx[i]< m && now.y+dy[i] < n ){
						if(map[now.x+dx[i]][now.y+dy[i]].type == 0) {
							tmp = new Area(now.x+dx[i],now.y+dy[i],2);
							q.offer(tmp);
							map[now.x+dx[i]][now.y+dy[i]].type = 2;
							area_cnt++;
						}
					}
				}
			}
			return area_cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		m = scn.nextInt();
		n = scn.nextInt();
		k = scn.nextInt();
		int tmp;
		int space_num=0;
		LinkedList<Integer> list =new LinkedList<Integer>();
		Map map = new Map(m,n);
		for(int i=0;i<k;i++) {
			Pos f = new Pos(scn.nextInt(),scn.nextInt());
			Pos s = new Pos(scn.nextInt(),scn.nextInt());
			map.square(f, s);
		}
		while(true) {
			tmp = map.find_space();
			if(tmp!=0) {
				list.add(tmp);
				space_num++;
			}
			else break;
		}
		Collections.sort(list);
		System.out.println(space_num);
		for(int i:list) {
			System.out.print(i+ " ");
		}
		scn.close();
	}
}