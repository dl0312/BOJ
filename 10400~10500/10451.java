import java.util.LinkedList;
import java.util.Scanner;

//	BOJ - 10451
//	Algorithm - DFS BFS

public class Main {
	
	private static class Pos{
		long x;
		long y;
		
		public Pos(long x, long y) {
			this.x = x;
			this.y = y;
		}
		public long distance(Pos pos) {
			return Math.abs(this.x+this.y-pos.x-pos.y);
		}
	}
	
	private static class Matrix{
		int n;
		int [][] matrix;
		
		public Matrix(Scanner scn) {
			this.n = scn.nextInt();
			matrix = new int [2][this.n];
			for(int i=0;i<this.n;i++) {
				this.matrix[0][i] = i;
				this.matrix[1][i] = scn.nextInt();
			}
		}
		
		public int permutation_cycle() {
			boolean [] visited = new boolean [this.n];
			int target=0;
			int tmp;
			int cnt=0;
			for(int i=0;i<this.n;i++) {
				visited[i] = false;
			}
			for(int i=0;i<this.n;i++) {
				if(visited[i]==false) {
					target = i+1;
					visited[i] = true;
					tmp = this.matrix[1][i];
					while(true) {
						tmp = this.matrix[1][tmp-1];
						if(tmp==target) {
							cnt++;
							while(true) {
								tmp = this.matrix[1][tmp-1];
								visited[tmp-1] = true;
								if(tmp==target) break;
							}
							break;
						}
					}
				}
			}
			return cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
			Matrix matrix = new Matrix(scn);
			System.out.println(matrix.permutation_cycle());
		}
		scn.close();
	}
}