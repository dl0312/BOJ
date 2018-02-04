import java.util.Arrays;
import java.util.Scanner;

//	BOJ - 14935
//	Algorithm - ?

public class Main {
		
	public static void FA(int num, int depth) {
		String str = Integer.toString(num);
		int result = str.indexOf(0)*str.length();
		if(depth>10) {
			System.out.print("NFA");
		}
		if(num==result) {
			System.out.print("FA");
		}
		else {
			FA(result,depth++);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int num = str.indexOf(0)*str.length();
		FA(num,0);
		scn.close();
	}
}