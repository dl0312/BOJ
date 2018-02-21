import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 2606
//	Algorithm - DFS BFS

public class Main {
	
	static int n;	//	the number of computer
	static Queue<Integer> q = new LinkedList<Integer>();
	
	private static class Map{
		int [][] map;
		boolean [] visited; 
		int area_cnt=0;
		
		public Map(int n) {
			this.map = new int [n][n];
			this.visited = new boolean [n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = 0;
				}	
			}
			for(int i=0;i<n;i++) {
				visited[i] = false;
			}
		}
		
		public void line(int f, int s) {
			map[f-1][s-1] = 1;
			map[s-1][f-1] = 1;
		}
		
		public int BFS(int now) {
			area_cnt=0;
			int tmp = now;
			q.offer(now);
			this.visited[tmp] = true;
			while(!q.isEmpty()) {
				now = q.poll();
				//System.out.println(now);
				//print();
				for(int i=0;i<n;i++) {
					if(map[now][i]==1 && visited[i]==false) {
						tmp = i;
						q.offer(tmp);
						visited[i] = true;
						area_cnt++;
					}
				}
			}
			return area_cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		Map map = new Map(n);
		int k = scn.nextInt();
		for(int i=0;i<k;i++) {
			map.line(scn.nextInt(), scn.nextInt());
		}
		System.out.println(map.BFS(0));
		scn.close();
	}
}