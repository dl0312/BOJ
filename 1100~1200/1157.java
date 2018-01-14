//	BOJ - 1157
//	Algorithm - String Process

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] alpha = new int [26];
		int max_alpha=0;
		int tmp_max_alpha=0;
		boolean rep_check = false;
		for(int i=0;i<26;i++) {
			alpha[i] = 0;
		}
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>=65 && str.charAt(i)<=90) {
				alpha[str.charAt(i)-65]++;
			}
			else if(str.charAt(i)>=97 && str.charAt(i)<=122) {
				alpha[str.charAt(i)-97]++;
			}
		}
		for(int i=0;i<26;i++) {
			if(alpha[i]>max_alpha) {
				max_alpha = alpha[i];
				tmp_max_alpha = i;
				rep_check = false;
			}
			else if(alpha[i] == max_alpha) {
				rep_check = true;
			}
		}
		//System.out.print(tmp_max_alpha + " " + max_alpha);
		if(rep_check == true) System.out.print("?");
		else System.out.print((char)(tmp_max_alpha+65));
	}
}
