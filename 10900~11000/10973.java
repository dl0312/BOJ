//	BOJ - 10973
//	Algorithm - Permutation

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static int[] update(int [] the_list, int n, int [] result) {
		int [] templist = new int [the_list.length-n];
		int tmp;
		System.arraycopy(the_list, n, templist, 0, the_list.length-n);
		Arrays.sort(templist);
		for(int i=0;i<templist.length/2;i++) {
			tmp = templist[i];
			templist[i] = templist[templist.length-i-1];
			templist[templist.length-i-1] = tmp;
		}
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
		int [] base_arr = new int [source.length];
		for(int i=0;i<source.length;i++) {
			base_arr[i] = i+1;
		}
		int [] result = new int [source.length];
		System.arraycopy(source, 0, result, 0, source.length);
		if(Arrays.equals(source, base_arr)) {
			System.out.print(-1);
		}
		else {
			for(int i=source.length-1;i>0;i--) {
				if(source[i]<source[i-1]) {
					for(int j=i;j<source.length;j++) {
						if(source[i-1]<=source[j]) {
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
			for(int j=0;j<source.length;j++) {
				System.out.print(source[j] + " ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int [n];
		int [] base_arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = scn.nextInt();
			base_arr[i] = i+1;
		}
		permute(arr);	
	}
}
