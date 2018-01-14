//	BOJ - 1316
//	Algorithm - String Process, Search

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t_num = scn.nextInt();
		int word_cnt = 0;
		String [] str_array = new String [t_num];
		String trash = scn.nextLine();
		for(int i=0;i<t_num;i++) {
			if(isGroupWord(scn.nextLine())) word_cnt++;
		}
		System.out.print(word_cnt);
	}
	
	public static boolean isGroupWord(String str) {
		int [] alpha = new int [26];
		char combo_alpha = 0;
		//System.out.println(str);
		for(int i=0;i<26;i++) {
			alpha[i] = 0;
		}
		for(int i=0;i<str.length();i++) {
			if(combo_alpha!=str.charAt(i) && alpha[str.charAt(i)-97]!=0) {
				return false;
			}
			alpha[str.charAt(i)-97]++;
			combo_alpha = str.charAt(i);
		}
		return true;
	}
}
