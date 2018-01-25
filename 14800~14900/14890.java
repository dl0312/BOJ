//	BOJ - 14890
//	Algorithm - ?
//	Samsung

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static class Line{
		int [] line;
		public Line(int [] ary) {
			this.line = ary;
		}
		
		public boolean check_slopable(Line line, int l) {
			int pivot=0;
			int cnt=0;
			boolean slope_flag = true;
			boolean pivot_flag = false;
			if(l==1) {
				for(int i=0;i<line.line.length;i++) {
					if(line.line[i]==line.line[pivot]-1) {
						pivot = i;
						pivot_flag=true;
					}
					else if(line.line[i]==line.line[pivot]+1) {
						if(i==pivot+1 && pivot_flag == true) {
							return false;
						}
						pivot = i;
						pivot_flag=false;
					}
					else if(Math.abs(line.line[i]-line.line[pivot])>=2) return false;
				}
				return true;
			}
			for(int i=0;i<line.line.length;i++) {
				if(line.line[i] == line.line[pivot]) {
					if(slope_flag==true) {
						cnt++;
					}
					else return false;
				}
				else if(line.line[i]==line.line[pivot]-1) {
					if(slope_flag==true) {
						slope_flag = false;
						cnt=1;
					}
					else if( slope_flag == false && cnt < l-1) {
						cnt++;
					}
					else if( slope_flag == false && cnt >= l-1) {
						pivot = i;
						slope_flag = true;
						cnt = 1;
						pivot_flag = true;
					}
				}
				else if(line.line[i]==line.line[pivot]+1) {
					if(slope_flag==true) {
						if(cnt<l || i<pivot+l || (i==pivot+l && pivot_flag == true) ) {
							return false;
						}
						pivot = i;
					}
				}
				else if(Math.abs(line.line[i]-line.line[pivot])>=2) return false;
			}
			if(slope_flag==true) return true;
			else return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int l = scn.nextInt();
		int [][] matrix = new int [n][n];
		int [] tmp_ary = new int [n];
		int total_slope=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = scn.nextInt();
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tmp_ary[j] = matrix[i][j];
			}
			Line line = new Line(tmp_ary);
//			System.out.println(Arrays.toString(line.line));
			if(line.check_slopable(line, l)==true) {
//				System.out.println("True!: " + Arrays.toString(line.line));
				total_slope++;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tmp_ary[j] = matrix[j][i];
			}
			Line line = new Line(tmp_ary);
//			System.out.println(Arrays.toString(line.line));
			if(line.check_slopable(line, l)==true) {
//				System.out.println("True!: " + Arrays.toString(line.line));
				total_slope++;
			}
		}
		System.out.println(total_slope);
	}
}
