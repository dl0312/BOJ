
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 11724
//	Algorithm - DFS BFS

public class Main {
	
	static int n;	//	정점의 개수
	static int m;	//	간선의 개수
	static Queue<Integer> q = new LinkedList<Integer>();
	
	private static class Matrix{
		int [][] matrix;
		boolean [] visited;

		public Matrix(int n){
			this.matrix = new int [n][n];
			this.visited = new boolean [n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					this.matrix[i][j] = 0;
				}
			}
			for(int i=0;i<n;i++) {
				visited[i] = false;
			}
		}
		
		public void Line(int f,int s) {
			this.matrix[f-1][s-1] = 1;
			this.matrix[s-1][f-1] = 1;
		}
		
		public int find_CC() {
			int CC_num=0;
			boolean flag = false;
			while(true) {
				flag = false;
				for(int i=0;i<n;i++) {
					if(visited[i]==false) {
						BFS(i);
						flag = true;
						CC_num++;
					}
				}
				if(flag == false) break;
			}
			return CC_num;
		}
		
		public void BFS(int now) {
			int tmp;
			q.offer(now);
			this.visited[now] = true;
			while(!q.isEmpty()) {
				now = q.poll();
				for(int i=0;i<n;i++) {
					if(this.matrix[now][i] == 1 && visited[i]==false) {
						tmp = i;
						q.offer(tmp);
						this.visited[i] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		Matrix matrix = new Matrix(n);
		for(int i=0;i<m;i++) {
			matrix.Line(scn.nextInt(), scn.nextInt());
		}
		System.out.println(matrix.find_CC());
		scn.close();
	}
}