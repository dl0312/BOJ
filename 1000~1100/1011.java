//	BOJ - 1011
//	Algorithm - Find Pattern

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.math.*;

public class Main {
	
	public static long operationNum(int x, int y) {
		long i=0;
		long c = y-x;
		if(c==1) {
			return 1;
		}
		while(true) {
			i++;
			if(c>((i*i-i)/2+i) && c<=(i*i+i)) {
				return 2*i;
			}
			else if(c>(i*i+i) && c<=((i*i+i)+i+1)) {
				return 2*i+1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t_num = scn.nextInt();
		int x, y;
		int [] visit;
		for(int i=0;i<t_num;i++) {
			x = scn.nextInt();
			y = scn.nextInt();
			System.out.println(operationNum(x,y));
		}
	}

}
