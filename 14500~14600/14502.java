//	BOJ - 14502
//	Algorithm - DFS
//	Samsung

import java.util.Scanner;

public class Main {
	
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	static boolean [][] visit;
	
	private static class map{
		int [][] matrix;
		
		public map() {
		}
		
		public map(int [][] input) {
			this.matrix = input;
		}
	}
	
	public static map buildWall(map input_map) {
		map builded = new map();
		return builded;
	}
	
	public static map spreadVirus(map input_map) {
		map spreaded = new map();
		
		return spreaded;
	}
	
	public static void dfs(int x, int y, map input) {
		visit[x][y] = true;
		System.out.print("("+x+", "+y+")");
		while(true) {
			for(int i=0;i<4;i++) {
				if(input.matrix[x+dx[i]][y+dy[i]]==0) {
					input.matrix[x+dx[i]][y+dy[i]]=1;
					dfs(x+dx[i],y+dy[i],input);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp_n;
		int n,m;
		int [][] tmp_matrix;
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		visit = new boolean[n][m];
		tmp_matrix = new int [n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp_matrix[i][j] = scn.nextInt();
			}
		}
		
		
	}
}
