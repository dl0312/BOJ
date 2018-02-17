import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//	BOJ - 1389
//	Algorithm - DFS BFS

public class Main {
	static int n,r;
	static int [][] matrix;
	static boolean [] visit;
	
	public static int bfs(int str,int end) {
		for(int i=0;i<n;i++) {
			visit[i] = false;
		}
		if(str==end) {
			return 0;
		}
		Queue <Element> q = new <Element> LinkedList();
		Element ele = new Element(str,0);
		q.offer(ele);
		visit[str] = true;
		while(!q.isEmpty()) {
			Element tmp = new Element(q.poll());
			for(int j = 0; j < n; j++){
			    if(matrix[tmp.num][j] == 1 && visit[j] == false){
			        q.offer(new Element(j,tmp.depth+1));
			        visit[j] = true;
			        if(j==end) {
			        	return tmp.depth+1;
			        }
			    }
			}
		}
		return 0;
	}
	
	private static class Element{
		int num;
		int depth;
		
		public Element(int num,int depth) {
			this.num = num;
			this.depth = depth;
		}
		
		public Element(Element ele) {
			this.num = ele.num;
			this.depth = ele.depth;
		}
	}
	
	private static class Matrix{
		int tmp_f,tmp_s;
		int [] bacon;
		int tmp_bacon=0;
		
		public Matrix(Scanner scn) {
			matrix = new int [n][n];
			visit = new boolean [n];
			this.bacon = new int [n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j] = 0;
				}
			}
			for(int i=0;i<r;i++) {
				tmp_f = scn.nextInt();
				tmp_s = scn.nextInt();
				matrix[tmp_f-1][tmp_s-1] = 1;
				matrix[tmp_s-1][tmp_f-1] = 1;
			}
		}
		public void bacon() {
			for(int i=0;i<n;i++) {
				tmp_bacon=0;
				for(int j=0;j<n;j++) {
					tmp_bacon+=bfs(i,j);
				}
				bacon[i] = tmp_bacon;
			}
		}
		
		public int min_bacon() {
			int min_p=0;
			int min_b=bacon[0];
			for(int i=1;i<n;i++) {
				if(bacon[i]<min_b) {
					min_b = bacon[i];
					min_p = i;
				}
			}
			return min_p+1;
		}
		
		public void print() {
			System.out.println(Arrays.toString(bacon));
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		r = scn.nextInt();
		Matrix matrix = new Matrix(scn);
		matrix.bacon();
		System.out.println(matrix.min_bacon());
		scn.close();
	}
}