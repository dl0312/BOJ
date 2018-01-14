//	BOJ - 2908
//	Algorithm - String Process

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		String tmp;
		String str_a = Integer.toString(a);
		String str_b = Integer.toString(b);
		tmp = str_a.substring(2)+str_a.substring(1,2)+str_a.substring(0, 1);
		str_a = tmp;
		a = Integer.parseInt(str_a);
		tmp = str_b.substring(2)+str_b.substring(1,2)+str_b.substring(0, 1);
		str_b = tmp;
		b = Integer.parseInt(str_b);
		if(a>b) System.out.print(a);
		else System.out.print(b);
		
		
	}
}
