
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 2644
//	Algorithm - DFS BFS

public class Main {
	
	static int n;	//	사람들의 수
	static Queue<Element> q = new LinkedList<Element>();
	
	public static class Element{
		int n;
		int depth = 0;
		
		public Element(int n, int depth) {
			this.n = n;
			this.depth = depth;
		}
		
		public void print() {
			System.out.println("n: " + n + " depth: " + depth);
		}
	}
	
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
		
		public int BFS(Element now,int target) {
			Element tmp;
			q.offer(now);
			this.visited[now.n] = true;
			while(!q.isEmpty()) {
				now = q.poll();
				if(now.n == target) {
					return now.depth;
				}
				for(int i=0;i<n;i++) {
					if(this.matrix[now.n][i] == 1 && visited[i]==false) {
						tmp = new Element(i,now.depth+1);
						q.offer(tmp);
						this.visited[i] = true;
					}
				}
			}
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		Matrix matrix = new Matrix(n);
		int f = scn.nextInt();
		int s = scn.nextInt();
		int m = scn.nextInt();
		for(int i=0;i<m;i++) {
			matrix.Line(scn.nextInt(), scn.nextInt());
		}
		System.out.println(matrix.BFS(new Element(f-1,0),s-1));
		scn.close();
	}
}