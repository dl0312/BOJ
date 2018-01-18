//	BOJ - 14502
//	Algorithm - DFS
//	Samsung

import java.util.Scanner;

public class Main {
	
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0};
	static boolean [][] visit;
	static pos [] available_pos;
	static int n,m;
	
	private static class map{
		int [][] matrix;
		
		public map() {
		}
		
		public map(int [][] input) {
			this.matrix = input;
		}
	}
	private static class pos{
		int x, y;
		public pos(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int solutionWall(map input_map) {
		int [][] tmp,tmp2 = new int [n][m];
		tmp = input_map.matrix;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp2[i][j] = tmp[i][j];
			}
		}
		map builded = new map(tmp);
		int cnt = 0;
		int tmp_empty=0;
		int max_empty=0;
		pos [] max_pos = new pos [3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(input_map.matrix[i][j] == 0) {
					available_pos[cnt] = new pos(i,j);
					cnt++;
				}
			}
		}
		for(int i=0;i<cnt-2;i++) {
			for(int j=i+1;j<cnt-1;j++) {
				for(int k=j+1;k<cnt;k++) {
					for(int a=0;a<n;a++) {
						for(int b=0;b<m;b++) {
							builded.matrix[a][b] = tmp2[a][b];
						}
					}
					//System.out.println(i + " " + j + " " + k);
					builded.matrix[available_pos[i].x][available_pos[i].y] = 1;
					builded.matrix[available_pos[j].x][available_pos[j].y] = 1;
					builded.matrix[available_pos[k].x][available_pos[k].y] = 1;
					builded = spreadVirus(builded);
					tmp_empty = checkMap(builded);
					if(max_empty<tmp_empty) {
						max_empty = tmp_empty;
						max_pos[0] = available_pos[i];
						max_pos[1] = available_pos[j];
						max_pos[2] = available_pos[k];
//						viewMap(builded);
//						System.out.print("("+max_pos[0].x+", "+max_pos[0].y+") ");
//						System.out.print("("+max_pos[1].x+", "+max_pos[1].y+") ");
//						System.out.print("("+max_pos[2].x+", "+max_pos[2].y+") ");
//						System.out.println("max : " + max_empty);
					}
				}
			}
		}
		return max_empty;
	}
	
	public static map spreadVirus(map input_map) {
		//map spreaded = new map();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(input_map.matrix[i][j] == 2){
					dfs(i,j,input_map);
				}
			}
		}
		return input_map;
	}
	
	public static void viewMap(map input_map) {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(input_map.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int checkMap(map input_map) {
		int empty=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(input_map.matrix[i][j]==0) {
					empty++;
				}
			}
		}
		return empty;
	}
	
	public static void dfs(int x, int y, map input) {
		//System.out.print("("+x+", "+y+")");
		while(true) {
			for(int i=0;i<4;i++) {
				if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m) {
					if(input.matrix[x+dx[i]][y+dy[i]]==0) {
						input.matrix[x+dx[i]][y+dy[i]]=2;
						//System.out.print("("+(x+dx[i])+", "+(y+dy[i])+")");
						dfs(x+dx[i],y+dy[i],input);
					}
				}
			}
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tmp_n;
		int [][] tmp_matrix;
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		visit = new boolean[n][m];
		available_pos = new pos [(n*m)*(n*m-1)*(n*m-2)/6];
		tmp_matrix = new int [n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp_matrix[i][j] = scn.nextInt();
			}
		}
		map map = new map(tmp_matrix);
		System.out.println(solutionWall(map));
	}
}
