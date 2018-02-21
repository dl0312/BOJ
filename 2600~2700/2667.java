import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 2667
//	Algorithm - DFS BFS
public class Main {
	
	static int n; // size of map
	static int k;
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
		
		public Map(int n) {
			this.map = new Area [n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = new Area(i,j,0);
				}	
			}
		}
		
		public void square(int [][] space) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(space[i][j]==1) {
						this.map[i][j].type = 1;
					}
				}
			}
		}
		
		public int find_space() {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j].type==1) {
						return(BFS(map[i][j]));
					}
				}
			}
			return 0;
		}
		
		public void print() {
			System.out.println();
			for(int i=0;i<n;i++) {
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
				//print();
				for(int i=0;i<4;i++) {
					if(now.x+dx[i]>=0 && now.y+dy[i]>=0 && now.x+dx[i]< n && now.y+dy[i] < n ){
						if(map[now.x+dx[i]][now.y+dy[i]].type == 1) {
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
		n = scn.nextInt();
		int tmp;
		int space_num=0;
		int [][] space;
		LinkedList<Integer> list =new LinkedList<Integer>();
		Map map = new Map(n);
		space = new int [n][n];
		String trash = scn.nextLine();
		for(int i=0;i<n;i++) {
			char [] char_ary = scn.nextLine().toCharArray();
			for(int j=0;j<char_ary.length;j++) {
				space[i][j] = char_ary[j]-48;
			}
		}
		map.square(space);
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
			System.out.println(i);
		}
		scn.close();
	}
}