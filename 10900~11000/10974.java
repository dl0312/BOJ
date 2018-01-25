//	BOJ - 10974
//	Algorithm - Permutation
//	Samsung

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	/*
	private static class Permutation{
		int n;			// n of nPr
		int r;			// r of nPr
		int [] res;		// return arr
		
		//	initialize
		public Permutation(int n,int r) {
			this.n = n;
			this.r = r;
			res = new int [r];
		}
		
		public void swap(int [] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		public void perm(int [] arr, int depth) {
			
			// if depth start with 0 return at depth == r
			if(depth == r) {
				System.out.println(Arrays.toString(res));
				return;
			}
			
			for(int i=depth;i<n;i++) {
				swap(arr,depth,i);			//	swap
				res[depth] = arr[depth];	//	input selected element
				perm(arr, depth+1);			//	recursive call
				swap(arr,depth,i);			//	restore
			}
		}	
	}
	*/
	
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
	
	public static void permute(int [] source){
		int [] reverse_source = new int [source.length];
		for(int i=0;i<source.length;i++) {
			reverse_source[source.length-i-1] = source[i];
		}
		int [] result = new int [source.length];
		int cnt =0;
		System.arraycopy(source, 0, result, 0, source.length);
		while( !Arrays.equals(source, reverse_source) && cnt < factorial(source.length)) {
			for(int i=0;i<source.length;i++) {
				System.out.print(source[i] + " ");
			}
			System.out.println();
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
		for(int i=0;i<source.length;i++) {
			System.out.print(source[i] + " ");
		}
		System.out.println();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		
//		Permutation main = new Permutation(n,n);
//		main.perm(arr, 0);
		permute(arr);
		
	}
}
