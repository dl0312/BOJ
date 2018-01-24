//	BOJ - 1722
//	Algorithm - Permutation

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static BigInteger factorial(BigInteger n) {
		if (n.intValue() <= 1)
			return n;
		else 
			return factorial(n.subtract(BigInteger.valueOf(1))).multiply(n);
	}
	
	public static void permute1(int [] arr, BigInteger count){
		int l = arr.length;
		int quot;
		count = count.subtract(BigInteger.valueOf(1));
		LinkedList<Integer> res = new LinkedList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		for(BigInteger i = BigInteger.valueOf(l-1);i.intValue()>0;i = i.subtract(BigInteger.valueOf(1))) {
		 	quot = list.get((count.divide(factorial(i))).intValue());
		 	res.add(quot); 
			list.remove(new Integer(quot));
			count = count.remainder(factorial(i));
		}
		quot = (int)list.get(0);
	 	res.add(quot); 
		list.remove(new Integer(quot));
		count = BigInteger.valueOf(0);
		for(int i=0;i<l;i++) {
			System.out.print(res.get(i) + " ");
		}
	}
	
	public static void permute2(int [] arr, int [] target){
		BigInteger cnt = new BigInteger("1");
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		for(int i=0;i<target.length;i++) {
			cnt = cnt.add(factorial(BigInteger.valueOf(target.length-i-1)).multiply(BigInteger.valueOf((list.indexOf(new Integer(target[i]))))));
			list.remove(new Integer(target[i]));
		}
		System.out.print(cnt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int [n];
		int [] target_arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		int problem_style = scn.nextInt();
		if(problem_style==1) {
			permute1(arr,BigInteger.valueOf(scn.nextLong()));
		}
		else {
			for(int i=0;i<n;i++) {
				target_arr[i] = scn.nextInt();
			}
			permute2(arr,target_arr);
		}
		scn.close();
	}
}
