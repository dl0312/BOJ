//	BOJ - 14888
//	Algorithm - ?
//	Samsung

import java.util.Scanner;
import java.util.Arrays;


public class Main {
	static int [] digit_ary;
	static int min_result,max_result;

	
	public static int calculate(int [] digit_ary, int [] operator_ary) {
		int result = digit_ary[0];
		for(int i=0;i<operator_ary.length;i++) {
			if(operator_ary[i] == 1) {
				result+=digit_ary[i+1];
			}
			else if(operator_ary[i] == 2) {
				result-=digit_ary[i+1];
			}
			else if(operator_ary[i] == 3) {
				result*=digit_ary[i+1];
			}
			else if(operator_ary[i] == 4) {
				if(result>=0) result/=digit_ary[i+1];
				else {
					result*=-1;
					result/=digit_ary[i+1];
					result*=-1;
				}
			}
		}
		return result;
	}
	
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
		min_result = max_result = calculate(digit_ary,source);
		while( !Arrays.equals(source, reverse_source) && cnt < factorial(source.length)) {
			/*
			for(int o=0;o<source.length;o++) {
				System.out.print(source[o] + " ");
			}
			System.out.println();
			*/
			cnt ++;
			if(calculate(digit_ary,source)>max_result) {
				max_result = calculate(digit_ary,source);
//				System.out.println("max : " + calculate(digit_ary,source));
			}
			if(calculate(digit_ary,source)<min_result) {
				min_result = calculate(digit_ary,source);
//				System.out.print("min : " + calculate(digit_ary,source));
			}
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
			/*
			for(int o=0;o<source.length;o++) {
				System.out.print(source[o] + " ");
			}
			System.out.println();
			*/
			
		}
//		System.out.println("cnt : " + cnt);
		if(calculate(digit_ary,source)>max_result) {
			max_result = calculate(digit_ary,source);
//			System.out.println("max : " + calculate(digit_ary,source));
		}
		if(calculate(digit_ary,source)<min_result) {
			min_result = calculate(digit_ary,source);
//			System.out.print("min : " + calculate(digit_ary,source));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int digit_num;
		int [] operator_num = new int [4];		// ( +, -, x, / )
		int [] general_operator_ary;
		Scanner scn = new Scanner(System.in);
		
		digit_num = scn.nextInt();
		digit_ary = new int [digit_num];
		for(int i=0;i<digit_num;i++) {
			digit_ary[i] = scn.nextInt();
		}
		for(int i=0;i<4;i++) {
			operator_num[i] = scn.nextInt();
		}
		scn.close();
		general_operator_ary = new int [digit_num-1];
		for(int i=0;i<digit_num-1;i++) {
			if(operator_num[0]!=0) {
				general_operator_ary[i] = 1;
				operator_num[0]--;
			}
			else if(operator_num[1]!=0) {
				general_operator_ary[i] = 2;
				operator_num[1]--;
			}
			else if(operator_num[2]!=0) {
				general_operator_ary[i] = 3;
				operator_num[2]--;
			}
			else if(operator_num[3]!=0) {
				general_operator_ary[i] = 4;
				operator_num[3]--;
			}
		}
		permute(general_operator_ary);
		System.out.println(max_result);
		System.out.print(min_result);
	}
}
