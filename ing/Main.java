
import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 14948
//	Algorithm - ?
//	2017 Sogang Programming Contest - Champion F¹ø

/*
 11122
2>3>12>1>3>2
0>0>0>1>0>0
43

4 3
2 5 2
3 4 3
12 1 3
1 3 2
 */

public class Main {
	private static int n,m;
	
	public static int[] update(int [] the_list, int n, int [] result) {
		int []templist = new int [the_list.length-n];
		System.arraycopy(the_list, n, templist, 0, the_list.length-n);
		Arrays.sort(templist);
		System.arraycopy(templist, 0, the_list, n, templist.length);
		System.arraycopy(the_list, 0, result, 0, the_list.length);
		return the_list;
	}
	
	public static int factorial(int n) {
		if (n <= 1)
			return n;
		else 
			return factorial(n-1) * n;
	}
	
	public static int [][] permute(int [] source){
		int [] reverse_source = new int [source.length];
		for(int i=0;i<source.length;i++) {
			reverse_source[source.length-i-1] = source[i];
		}
		int [][] permute_ary = new int [permute_num(n-1,m-1)][n+m-2];
		int [] result = new int [source.length];
		int cnt =0;
		System.arraycopy(source, 0, result, 0, source.length);
		while( !Arrays.equals(source, reverse_source) && cnt < factorial(source.length)) {
			System.arraycopy(source, 0, permute_ary[cnt], 0, source.length);
			cnt++;
			for(int i=source.length-1;i>0;i--) {
				if(source[i]>source[i-1]) {
					for(int j=i;j<source.length;j++) {
						if(source[i-1]>=source[j]) {
							int tmp = source[i-1];
							source[i-1] = source[j-1];
							source[j-1] = tmp;
							source = update(source,i,result);
							break;
						}
						else if(j==source.length-1) {
							if(source[i-1]!=source[j]) {
								int tmp = source[i-1];
								source[i-1] = source[j];
								source[j] = tmp;
								source = update(source,i,result);
								break;
							}
							else {
								for(int k=j;k>0;k--) {
									if(source[i-1]!=source[k]) {
										int tmp = source[i-1];
										source[i-1] = source[k];
										source[k] = tmp;
										source = update(source,i,result);
										break;
									}
								}
							}
						}
					}
					break;
				}
			}
		}
		System.arraycopy(source, 0, permute_ary[cnt], 0, source.length);
		cnt++;
		return permute_ary;
	}
	
	public static int permute_num(int n,int m) {
		return (factorial(n+m)/(factorial(n)*factorial(m)));
	}
	
	private static class Path{
		int [] path;
		boolean [] curve;
		int max_pivot;
		int max_lv=0;
		
		public Path(int [] path) {
			this.path = path;
		}
		public Path() {
			this.path = new int [n+m-1];
			this.curve = new boolean [n+m-1];
			for(int i=0;i<n+m-1;i++) {
				this.path[i] = 0;
				this.curve[i] = false;
			}
		}
		public int max_lv() {
			for(int i=0;i<n+m-1;i++) {
				if(i!=max_pivot) {
					if(max_lv<this.path[i]) {
						max_lv=this.path[i];
					}
				}
			}
			return this.max_lv;
		}
		
		public void print() {
			this.max_lv();
			System.out.println(Arrays.toString(this.path));
			System.out.println(Arrays.toString(this.curve));
			System.out.println("max_pivot: " + this.max_pivot);
			System.out.println("max_lv: " + this.max_lv);
		}
	}
	
	private static class Map{
		int [][] map;
		public Map(Scanner scn) {
			this.map = new int [n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					this.map[i][j] = scn.nextInt();
				}
			}
		}
		
		public void print() {
			for(int i=0;i<n;i++) {
				System.out.println(map[i]);
			}
		}
		
		public Path path(int [] permute_ary) {
			Path path = new Path();
			int pivot=0;
			int x_pivot=0;
			int y_pivot=0;
			int max_num=0;
			path.path[pivot] = map[x_pivot][y_pivot];
			pivot++;
			if(permute_ary[0]==1) {
				x_pivot++;
				path.path[pivot] = this.map[x_pivot][y_pivot];
			}
			else if(permute_ary[0]==2) {
				y_pivot++;
				path.path[pivot] = this.map[x_pivot][y_pivot];
			}
			pivot++;
			for(int i=1;i<n+m-3;i++) {
				if(permute_ary[i]!=permute_ary[i+1]) {
					path.curve[i+1] = true;
				}
				if(permute_ary[i]==1) {
					x_pivot++;
					path.path[pivot] = this.map[x_pivot][y_pivot];
					if(max_num<path.path[pivot] && path.curve[i]==false) {
						max_num = path.path[pivot];
						path.max_pivot = pivot;
					}
				}
				else if(permute_ary[i]==2) {
					y_pivot++;
					path.path[pivot] = this.map[x_pivot][y_pivot];
					if(max_num<path.path[pivot] && path.curve[i]==false) {
						max_num = path.path[pivot];
						path.max_pivot = pivot;
					}
				}
				pivot++;
			}
			if(permute_ary[n+m-3]==1) {
				x_pivot++;
				path.path[pivot] = this.map[x_pivot][y_pivot];
			}
			else if(permute_ary[n+m-3]==2) {
				y_pivot++;
				path.path[pivot] = this.map[x_pivot][y_pivot];
			}
			pivot++;
			
			return path;
		}
		/*
		public int exit(int [][] permute_ary) {
			Path path = new Path();
			int pivot = 0;
			path.path[0] = this.map[0][0];
			
		}
		*/
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		Map map = new Map(scn);
		int min_lv=0;
		int [] ary = new int [n+m-2];
		int pivot = 0;
		for(;pivot<n-1;pivot++) {	// down : 1
			ary[pivot] = 1;
		}
		for(;pivot<n+m-2;pivot++) {
			ary[pivot] = 2;
		}
		int [][] permute_ary = permute(ary);
		for(int i=0;i<permute_num(n-1,m-1);i++) {
			if(i==0) {
				min_lv = map.path(permute_ary[i]).max_lv();
			}
			if(min_lv > map.path(permute_ary[i]).max_lv()) {
				min_lv = map.path(permute_ary[i]).max_lv();
			}
		}
		System.out.println(min_lv);
		scn.close();
	}
}