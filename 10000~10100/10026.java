import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//	BOJ - 10026
//	USACO March 2014 Contest Bronze 3¹ø
//	Algorithm - BFS

public class Main {
	
	static char [][] map;
	static int size;
	static boolean [][] visited;
	static int area_num=0;
	static int area_num_replaced;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int cnt=0;
	
	private static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS(Pos now) {
		Queue<Pos> q = new LinkedList<Pos>();
		char color = map[now.x][now.y];
		Pos tmp = now;
		q.offer(now);
		visited[now.x][now.y] = true;
		while(!q.isEmpty()) {
			now = q.poll();
			cnt++;
			for(int i=0;i<4;i++) {
				if(now.x+dx[i]>=0 && now.y+dy[i]>=0 && now.x+dx[i]< size && now.y+dy[i] < size){
					if(map[now.x+dx[i]][now.y+dy[i]] == color) {
						if(visited[now.x+dx[i]][now.y+dy[i]] == false) {
							tmp = new Pos(now.x+dx[i],now.y+dy[i]);
							visited[now.x+dx[i]][now.y+dy[i]] = true;
							q.offer(tmp);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		size = scn.nextInt();
		map = new char [size][size];
		visited = new boolean [size][size];
		boolean flag = false;
		String trash = scn.nextLine();
		for(int i=0;i<size;i++) {
				String str = scn.nextLine();
				for(int j=0;j<size;j++) {
					map[i][j] = str.charAt(j);
					visited[i][j] = false;
				}
		}
		scn.close();
		while(true) {
			flag = false;
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(visited[i][j] == false) {
						flag = true;
						BFS(new Pos(i,j));
						area_num++;
						continue;
					}
				}
			}
			if(flag == false) {
				break;
			}
		}
		System.out.print(area_num);
		cnt = 0;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				visited[i][j] = false;
				if(map[i][j]=='R') {
					map[i][j] = 'G';
				}
			}
		}
		while(true) {
			flag = false;
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					if(visited[i][j] == false) {
						flag = true;
						BFS(new Pos(i,j));
						area_num_replaced++;
						continue;
					}
				}
			}
			if(flag == false) {
				break;
			}
		}
		System.out.print(" "+area_num_replaced);
	}
}