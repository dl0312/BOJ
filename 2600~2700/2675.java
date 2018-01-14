//	BOJ - 2675
//	Algorithm - String Process

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int a;
	static int b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t_num = scn.nextInt();
		int dup_num=0;
		String str;
		for(int i=0;i<t_num;i++) {
			dup_num = scn.nextInt();
			str = scn.nextLine();
			for(int j=1;j<str.length();j++) {
				for(int k=0;k<dup_num;k++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
