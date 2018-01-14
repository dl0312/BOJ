//	BOJ - 2577
//	Algorithm - implement


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		int result;
		int [] digit = new int [10];
		for(int i=0;i<10;i++) {
			digit[i] = 0;
		}
		Scanner scn = new Scanner(System.in);
		a = scn.nextInt();
		b = scn.nextInt();
		c = scn.nextInt();
		result = a*b*c;
		//System.out.println(result);
		String numstr = String.valueOf(result);
		char [] asChar = numstr.toCharArray();
		for(char d : asChar){
			digit[d-48]++;
			//System.out.print(digit[d-48] + "++ ");
		}
		for(int i=0;i<10;i++) {
			System.out.println(digit[i]);
		}
	}
}
