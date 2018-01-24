//	BOJ - 5402
//	Algorithm - Permutation

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static BigInteger factorial(BigInteger n) {
		if (n.intValue() <= 1) return n;
		else return factorial(n.subtract(BigInteger.valueOf(1))).multiply(n);
	}
	
	public static void permute(char [] target){
		LinkedList<Character> list = new LinkedList<Character>();		// sorted List
		int l = target.length;
		BigInteger cnt = new BigInteger("0");
		for(int i=0;i<l;i++) {
			list.add(target[i]);
		}
		Collections.sort(list);
		for(int i=0;i<l;i++) {
			LinkedList<Character> tmp = new LinkedList<Character>();
			for(int j=0;j<list.toArray().length;j++) {
				tmp.add(list.get(j));
			}
			BigInteger tmp_cnt = new BigInteger("1");
			while(!tmp.isEmpty()) {
				char tmp_char = tmp.get(0);
				BigInteger tmp_cnt2 = new BigInteger("1");
				int cnt2=0;
				while(true) {
					if(tmp.contains(new Character(tmp_char))) {
						cnt2++;
						tmp_cnt2 = tmp_cnt2.multiply(BigInteger.valueOf(cnt2));
						int idx = tmp.indexOf(new Character(tmp_char));
						tmp.remove(idx);
					}
					else {
						tmp_cnt = tmp_cnt.multiply(tmp_cnt2);
						break;
					}
				}
			}
			cnt = cnt.add((factorial(BigInteger.valueOf(l-i-1)).multiply(BigInteger.valueOf((list.indexOf(new Character(target[i])))))).divide(tmp_cnt));
			list.remove(new Character(target[i]));
//			System.out.print("cnt: " + cnt + " ");
		}
//		System.out.println();
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		String trash = scn.nextLine();
		String str = new String();
		for(int i=0;i<n;i++) {
			str = scn.nextLine();
			permute(str.toCharArray());
		}
		scn.close();
	}
}
