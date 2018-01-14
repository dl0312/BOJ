//	BOJ - 10809
//	Algorithm - String Process


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] alpha = new int [26];
		for(int i=0;i<26;i++) {
			alpha[i] = -1;
		}
		Scanner scn = new Scanner(System.in);
		//String trash = scn.nextLine();
		String str = scn.nextLine();
		for(int i=0;i<str.length();i++) {
			if(alpha[(int)str.charAt(i)-97] == -1) {
				alpha[(int)str.charAt(i)-97] = i;
			}
		}
		for(int i=0;i<26;i++) {
			System.out.print(alpha[i] + " ");
		}
	}
}
