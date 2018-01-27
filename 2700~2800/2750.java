//	BOJ - 2750
//	Algorithm - Sorting

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scn = new Scanner(System.in);
		int length = scn.nextInt();
		int [] ary = new int [length];
		for(int i=0;i<length;i++) {
			ary[i] = scn.nextInt();
		}
		Arrays.sort(ary);
		for(int i=0;i<length;i++) {
			System.out.println(ary[i]);
		}
		scn.close();
	}
}
